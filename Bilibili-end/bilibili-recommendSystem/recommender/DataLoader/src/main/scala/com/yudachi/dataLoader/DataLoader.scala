package com.yudachi.dataLoader

import java.net.InetAddress

import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.{MongoClient, MongoClientURI}
import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.elasticsearch.transport.client.PreBuiltTransportClient

case class Video(id: String, title: String, upid: String, partition_1: String, partition_2: String, upload_time: String, highest_rank: Int, play_num: Int, danmu_num: Int, like_num: Int, coin_num: Int, collect_num: Int, share_num: Int, video_info: String, tag: String)

//评分
case class VideoRating(LFMuid: Int, LFMvid: Int, score: Double, timestamp: Long)

//标签
case class Tag(tag: String, LFMvid: Int, LFMuid: Int)

object ConnHelper extends Serializable{
    lazy val mongoClient = MongoClient(MongoClientURI("mongodb://localhost:27017/bilibili-recommender"))
}

/**
  * @Description Es配置类
  * @Params httpHosts: http主机列表 逗号分隔
  * @Params transportHosts: transportHosts主机列表
  * @Params  index: 需要操作的索引
  * @Params  clustername: 集群名称 默认elasticsearch 我配置的是escluster
  **/
case class ESConfig(httpHosts : String, transportHosts : String, index : String, clustername:String)


object DataLoader {
    def main(args: Array[String]): Unit = {
        val config = Map(
            "spark.cores" -> "local[*]",
            "mongo.uri" -> "mongodb://localhost:27017/bilibili-recommender",
            "mongo.db" -> "bilibili-recommender",
            "es.httpHosts" -> "hadoop2:9200",
            "es.transportHosts" -> "hadoop2:9300",
            "es.index" -> "bilibili",
            "es.cluster.name" -> "escluster"
        )

        // 创建SparkConfig
        val sparkConf = new SparkConf().setMaster(config("spark.cores")).setAppName("DataLoader")

        // 创建SparkSession
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        // 得到Spark上下文对象
        val sc = sparkSession.sparkContext

        // 数据库操作
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

        videoDF.createOrReplaceTempView("video")

        val tagsDF = sparkSession.sql("select * from video")

        tagsDF.foreach(
            item=> {
                val vid = item.getAs[String]("id")
                val tag = item.getAs[String]("tag")
                val tagList = ConnHelper.mongoClient("bilibili-recommender")("UserRecord")
                    .find(MongoDBObject("vid" -> vid))
                    .toArray
                    .map {
                        obj => {
                            //case class Tag(LFMuid: Int, LFMvid: Int, tag: String, timestamp: Long)
                            (obj.get("LFMuid").toString.toInt, obj.get("LFMvid").toString.toInt, tag.toString)
                        }
                    }

                ConnHelper.mongoClient("bilibili-recommender")("Tag")
                    .insert(
                        MongoDBObject(
                            "LFMuid" -> tagList(0)._1,
                            "LFMvid" -> tagList(0)._2,
                            "tag" -> tagList(0)._3
                        )
                    )
            }
        )

        implicit val esConfig = ESConfig(config("es.httpHosts"),config("es.transportHosts"),config("es.index"),config("es.cluster.name"))


        val tagDF = sparkSession.read
            .option("uri", config("mongo.uri"))
            .option("collection", "Tag")
            .format("com.mongodb.spark.sql")
            .load()
            .as[Tag]
            .toDF()

        tagDF.createOrReplaceTempView("tag")

        val tmp = sparkSession.sql("select LFMvid, LFMuid, tag from tag")
        val videoWithTagsDF = videoDF.join(tmp, Seq("tag"), joinType = "left")


        //保存数据到ES
        storeDataInES(videoWithTagsDF)

    }


    def storeDFInMongoDB(df : DataFrame, collection_name : String)={
        df.write
            .option("uri","mongodb://localhost:27017/bilibili-recommender")
            .option("collection",collection_name)
            .mode("overwrite")
            .format("com.mongodb.spark.sql")
            .save()
    }

    def storeDataInES(videoWithTagsDF : DataFrame)(implicit esConfig : ESConfig): Unit = {
        //新建一个配置
        val settings = Settings.builder().put("cluster.name",esConfig.clustername).build()

        //新建一个ES客户端
        val esClient = new PreBuiltTransportClient(settings)

        //将TransportHosts添加到esClient中
        val REGEX_HOST_PORT = "(.+):(\\d+)".r
        esConfig.transportHosts.split(",").foreach{
            case REGEX_HOST_PORT(host : String, port : String) => {
                esClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),port.toInt))
            }
        }

        //需要清除ES中遗留的数据
        if(esClient.admin().indices().exists(new IndicesExistsRequest(esConfig.index)).actionGet().isExists){
            esClient.admin().indices().delete(new DeleteIndexRequest(esConfig.index))
        }

        //将数据写入到ES中
        videoWithTagsDF
            .write
            .option("es.nodes",esConfig.httpHosts)
            .option("es.http.timeout","100m")
            .option("es.mapping.id","id")
            .mode("overwrite")
            .format("org.elasticsearch.spark.sql")
            .save(esConfig.index + "/" + "videoWithTags")
    }
}
