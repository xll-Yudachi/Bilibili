import org.apache.spark.SparkConf
import org.apache.spark.mllib.recommendation.{ALS, Rating}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.jblas.DoubleMatrix

case class Video(id: String, title: String, upid: String, partition_1: String, partition_2: String, upload_time: String, highest_rank: Int, play_num: Int, danmu_num: Int, like_num: Int, coin_num: Int, collect_num: Int, share_num: Int, video_info: String, tag: String)

//用户记录基本信息
case class UserRecord(uid: String, vid: String, isPlay:Int, isLike: Int, isCoin: Int, isCollect: Int, isShare: Int, timestamp: Long, LFMuid: Int, LFMvid: Int)

//基于评分的LFM模型
case class VideoRating(LFMuid: Int, LFMvid: Int, score: Double, timestamp: Long)

//基准推荐对象
case class Recommendation(vid: Int, score:Double)

//基于预测评分的用户推荐列表
case class UserRecs(uid: Int, recs: Seq[Recommendation])

//基于LFM电影特征向量的电影相似度列表
case class MovieRecs(vid: Int, recs: Seq[Recommendation])


object LFMRecommender {

    def main(args: Array[String]): Unit = {
        // 创建SparkConfig
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("LFMRecommender")

        //创建SparkSession
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        //得到SparkContext
        val sc = sparkSession.sparkContext

        import sparkSession.implicits._

        //加载用户记录表
        val UserRecordDF = sparkSession
            .read
            .option("uri", "mongodb://localhost:27017/bilibili-recommender")
            .option("collection", "UserRecord")
            .format("com.mongodb.spark.sql")
            .load()
            .as[UserRecord]
            .toDF()

        UserRecordDF.createOrReplaceTempView("userRecord")

        //预处理
        val VideoRatingDF = sparkSession.sql("select * from userRecord")
            .rdd
            .map {
                case (row) => {
                    VideoRating(row.getAs[Int]("LFMuid"), row.getAs[Int]("LFMvid"), 3 + row.getAs[Int]("isLike").*(2 * 0.4).+(row.getAs[Int]("isCoin").*(2 * 0.3)).+(row.getAs[Int]("isCollect").*(2 * 0.2)).+(row.getAs[Int]("isShare").*(2 * 0.1)), row.getAs[Long]("timestamp"))
                }
            }
            .toDF()
        storeDFInMongoDB(VideoRatingDF, "VideoRating")


        // 加载数据
        val videoRatingRDD: RDD[(Int, Int, Double)] = sparkSession
            .read
            .option("collection", "VideoRating")
            .option("uri", "mongodb://localhost:27017/bilibili-recommender")
            .format("com.mongodb.spark.sql")
            .load()
            .as[VideoRating]
            .rdd
            .map(videoRating => (videoRating.LFMuid, videoRating.LFMvid, videoRating.score))
            .cache()

        // 从videoRating数据中提取所有的uid和vid 去重
        val userRDD = videoRatingRDD.map(_._1).distinct()
        val videoRDD = videoRatingRDD.map(_._2).distinct()

        //训练隐语义模型
        val trainData: RDD[Rating] = videoRatingRDD.map(x => Rating(x._1, x._2, x._3))

        //rank 隐特征维数 相当于k
        //iterations 定P求Q 定Q求P 的最小交替二乘法的迭代次数
        //lambda 正则化项系数
        val(rank, iterations, lambda) = (20, 5, 0.1)

        //训练模型
        val trainModel = ALS.train(trainData, rank, iterations, lambda)

        //基于用户和视频的隐特征，计算预测评分，得到用户的推荐列表
        //计算User和Video的笛卡尔积，得到一个空的评分矩阵
        val userVideos = userRDD.cartesian(videoRDD)

        //调用训练模型的predict方法，预测评分
        val preRatings = trainModel.predict(userVideos)

        val userRecs = preRatings
            //过滤出评分大于0的项
            .filter(_.rating > 0)
            .map(rating => (rating.user, (rating.product, rating.rating)))
            .groupByKey()
            .map {
                case (uid, recs) => {
                    UserRecs(uid,
                        recs
                            .toList
                            .sortWith(_._2 > _._2).take(20)
                            .map(data => {
                                Recommendation(data._1, data._2)
                            })
                    )
                }
            }
            .toDF()
        storeDFInMongoDB(userRecs, "UserRecs")


        //计算视频相似度 实时推荐模块
        //获取视频的特征矩阵，数据格式 RDD[(scala.Int, scala.Array[scala.Double])]
        val videoFeatures = trainModel.productFeatures.map {
            case (vid, features) => {
                (vid, new DoubleMatrix(features))
            }
        }

        //视频推荐列表
        //计算笛卡尔积 并过滤合并
        val videoRecs = videoFeatures
            .cartesian(videoFeatures)
            .filter {
                case (v1, v2) => {
                    v1._1 != v2._1
                }
            }
            .map {
                case (v1, v2) => {
                    //计算两个视频间的余弦相似度
                    val simScore = consinSim(v1._2, v2._2)
                    (v1._1, (v2._1, simScore))
                }
            }
            // 过滤余弦相似度大于0.6的视频
            .filter(_._2._2 > 0.6)
            .groupByKey()
            .map {
                case (vid, videos) => {
                    MovieRecs(
                        vid,
                        videos
                            .toList
                            .sortWith(_._2 > _._2)
                            .map {
                                video => {
                                    Recommendation(video._1, video._2)
                                }
                            }
                    )
                }
            }
            .toDF()

        storeDFInMongoDB(videoRecs, "VideoRecs")


    }

    def storeDFInMySQLDB(df: DataFrame, collection_name: String): Unit =
    {
        df.write
            .format("jdbc")
            .option("url", "jdbc:mysql://localhost:3306/bilibili") //jdbc连接的地址
            .option("driver", "com.mysql.jdbc.Driver") //驱动
            .option("dbtable", collection_name) //视频信息表
            .option("user", "root") //用户名
            .option("password", "ZUIEWANGGUAN") //密码
            .mode("overwrite")
            .save()
    }

    def storeDFInMongoDB(df : DataFrame, collection_name : String)={
        df.write
            .option("uri","mongodb://localhost:27017/bilibili-recommender")
            .option("collection",collection_name)
            .mode("overwrite")
            .format("com.mongodb.spark.sql")
            .save()
    }

    // 余弦相似度（正则化）
    def consinSim(video1: DoubleMatrix, video2: DoubleMatrix): Double ={
        video1.dot(video2) / (video1.norm2() * video2.norm2())
    }
}
