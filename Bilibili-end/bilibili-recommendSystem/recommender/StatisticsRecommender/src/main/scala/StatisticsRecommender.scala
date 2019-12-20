import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

case class Video(id: String, title: String, upid: String, partition_1: String, partition_2: String, upload_time: String, highest_rank: Int, play_num: Int, danmu_num: Int, like_num: Int, coin_num: Int, collect_num: Int, share_num: Int, video_info: String, tag: String)

case class Category(id: Int, parentid: Int, categoryname: String)

//推荐基准类
case class Recommendation(id:String, score:Double)

//类别推荐
case class CategoryRecommendation(category:String, recs:Seq[Recommendation])


object StatisticsRecommender {

    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("StatisticsRecommender")

        //创建SparkSession
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        //SparkContext
        val sc = sparkSession.sparkContext

        //支持SparkSQL的DF操作
        import sparkSession.implicits._


        val videoDF = sparkSession.read
            .format("jdbc")
            .option("url", "jdbc:mysql://localhost:3306/bilibili") //jdbc连接的地址
            .option("driver", "com.mysql.jdbc.Driver") //驱动
            .option("dbtable", "video") //视频信息表
            .option("user", "root") //用户名
            .option("password", "ZUIEWANGGUAN") //密码
            .load()
            .as[Video]
            .toDF()

        val categoryDF = sparkSession.read
            .format("jdbc")
            .option("url", "jdbc:mysql://localhost:3306/bilibili") //jdbc连接的地址
            .option("driver", "com.mysql.jdbc.Driver") //驱动
            .option("dbtable", "category") //视频类别表
            .option("user", "root") //用户名
            .option("password", "ZUIEWANGGUAN") //密码
            .load()
            .as[Category]
            .toDF()

        videoDF.createOrReplaceTempView("video")
        categoryDF.createOrReplaceTempView("category")


        //TODO: 不同的统计推荐结果
        //1. 历史热门统计，历史播放数最多
        val rateMoreVideosDF = sparkSession.sql("SELECT id, play_num from video ORDER BY play_num desc")
        storeDFInMongoDB(rateMoreVideosDF, "RateMoreVideos")


        //2. 近期热门统计， 按照"yyyyMMdd"格式选取最近的视频数据
        // 注册udf用户自定义函数
        sparkSession.udf.register("changeDate", (uploadTime: String)=>{
            uploadTime.split(" ")(0)
        })

        //原始数据预处理
        val ratingOfYearMonth = sparkSession.sql("select id, title, play_num, changeDate(upload_time) as yearmonth from video")
        ratingOfYearMonth.createOrReplaceTempView("ratingOfYearMonth")

        //近期热门统计
        val rateMoreRecentlyVideoDF = sparkSession.sql("select id, title, play_num, yearmonth from ratingOfYearMonth order by yearmonth desc, play_num desc")
        storeDFInMongoDB(rateMoreRecentlyVideoDF, "RateMoreRecentlyVideos")


        //3. 各类别视频Top统计
        val categoryList = sparkSession.sql("SELECT c1.categoryname as cat1, c2.categoryname as cat2 from category c1 LEFT JOIN category c2 on c1.id = c2.parentid order by c1.id")
            .rdd
            .take(85)

        val categoryRDD = sc.parallelize(categoryList)

        val categoryTopMovies = categoryRDD
            .cartesian(videoDF.rdd)
            .filter {
                case (category, videoRow) => {
                    videoRow.getAs[String]("partition_1").contains(category.getAs[String]("cat1")).&&(videoRow.getAs[String]("partition_2").contains(category.getAs[String]("cat2")))
                }
            }
            //case class Recommendation(id:String, score:Double)
            //目标格式=>(类型,(视频编号,平均分))
            .map {
            case (category, videoRow) => {
                (category, (videoRow.getAs[String]("id"), videoRow.getAs[Int]("like_num").*(0.4).+(videoRow.getAs[Int]("coin_num").*(0.3)).+(videoRow.getAs[Int]("collect_num").*(0.2)).+(videoRow.getAs[Int]("share_num").*(0.1))))
            }
        }
            .groupByKey()
            .map {
                //数据源格式->(类型,RDD集合(视频编号,平均分))
                //目标格式 -> case class CategoryRecommendation(category:String, recs:Seq[Recommendation])
                case (category, datas) => {
                    CategoryRecommendation(category.toString(), datas.toList.sortWith(_._2 > _._2).take(10).map(data => Recommendation(data._1, data._2)))
                }
            }
            .toDF()

            storeDFInMongoDB(categoryTopMovies, "categoryTopMovies")

    }

    def storeDFInMySQLDB(df: DataFrame, collection_name: String): Unit ={
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
}
