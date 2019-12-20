import org.apache.spark.SparkConf
import org.apache.spark.ml.feature.{HashingTF, IDF, Tokenizer}
import org.apache.spark.ml.linalg.SparseVector
import org.apache.spark.sql.SparkSession
import org.jblas.DoubleMatrix

case class Video(id: String, title: String, upid: String, partition_1: String, partition_2: String, upload_time: String, highest_rank: Int, play_num: Int, danmu_num: Int, like_num: Int, coin_num: Int, collect_num: Int, share_num: Int, video_info: String, tag: String)

//推荐对象
case class Recommendation(vid: String, score:Double)

//视频相似度矩阵
case class VideoTagsRecs(vid: String, recs: Seq[Recommendation])

object ContentRecommender {

    def main(args: Array[String]): Unit = {
        //创建SparkConfig
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("ContentRecommender")

        //创建SparkSession
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        //得到Spark上下文对象
        val sc = sparkSession.sparkContext

        //数据库操作
        import sparkSession.implicits._

        //加载数据
        val videoDF = sparkSession.read
            .format("jdbc")
            .option("url", "jdbc:mysql://localhost:3306/bilibili") //jdbc连接的地址
            .option("driver", "com.mysql.jdbc.Driver") //驱动
            .option("dbtable", "video") //视频信息表
            .option("user", "root") //用户名
            .option("password", "ZUIEWANGGUAN") //密码
            .load()
            .as[Video]
            .map{
                video => {
                    //提取视频编号、视频名称、视频标签
                    (video.id, video.title, video.tag.map{
                        character => if (character == '|') ' ' else character
                    })
                }
            }
            .toDF("id","title","tag")
            .cache()


        //TODO 用TF-IDF从内容信息中提取电影特征向量
        //创建一个分词器，默认按空格分隔(输入列为tag 输出列为tags)
        val tokenizer = new Tokenizer().setInputCol("tag").setOutputCol("tags")

        //用分词器对原始数据进行转换 生成新列
        val tagsData = tokenizer.transform(videoDF)

        //引入HashingTF工具，可以把一个词语序列转换成对应的词频
        val hashingTF = new HashingTF().setInputCol("tags").setOutputCol("tagsFeaturesRaw").setNumFeatures(1000)

        val tagsFeaturesDF = hashingTF.transform(tagsData)

        //引入IDF工具 得到IDF模型
        val idf = new IDF().setInputCol("tagsFeaturesRaw").setOutputCol("tagsFeatures")

        //训练idf模型,得到每个词的逆文档频率
        val IDFModel = idf.fit(tagsFeaturesDF)
        //用模型对原数据进行处理，得到文档中每个词的tf-idf，作为新的特征向量
        val rescaleDF = IDFModel.transform(tagsFeaturesDF)

        //rescaleDF.show(false)

        val videoTagsFeatures = rescaleDF
            .map {
                row => {
                    (row.getAs[String]("id"), row.getAs[SparseVector]("tagsFeatures").toArray)
                }
            }
            .rdd
            .map {
                //转换成(id,特征向量组)的格式
                x => (x._1, new DoubleMatrix(x._2))
            }

        // 对所有视频标签进行相似度计算
        val videoTagsRecs = videoTagsFeatures
            .cartesian(videoTagsFeatures)
            .filter {
                case (a, b) => {
                    a._1 != b._1
                }
            }
            .map {
                case (a, b) => {
                    val simScore = consinSim(a._2, b._2)
                    (a._1, (b._1, simScore))
                }
            }
            //数据量增长后可以适当调高
            .filter(_._2._2 > 0.2)
            .groupByKey()
            .map {
                case (id, videos) => {
                    VideoTagsRecs(
                        id,
                        videos
                            .toArray
                            .sortWith(_._2 > _._2)
                            .take(20)
                            .map {
                                x => Recommendation(x._1, x._2)
                            }
                    )
                }
            }
            .toDF()

        videoTagsRecs
            .write
            .option("uri", "mongodb://localhost:27017/bilibili-recommender")
            .option("collection", "VideoTagsRecs")
            .mode("overwrite")
            .format("com.mongodb.spark.sql")
            .save()

        sparkSession.stop()
    }

    // 余弦相似度
    def consinSim(v1: DoubleMatrix, v2: DoubleMatrix): Double ={
        v1.dot(v2) / (v1.norm2() * v2.norm2())
    }

}
