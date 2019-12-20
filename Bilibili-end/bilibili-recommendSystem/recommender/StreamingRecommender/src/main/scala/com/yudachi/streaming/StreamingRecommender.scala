package com.yudachi.streaming


import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.{MongoClient, MongoClientURI}
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import redis.clients.jedis.Jedis
//redis操作返回java类，为了用map操作需要引入转化类
import scala.collection.JavaConversions._

object ConnHelper extends Serializable{
    lazy val jedis = new Jedis("hadoop2")
    lazy val mongoClient = MongoClient(MongoClientURI("mongodb://localhost:27017/bilibili-recommender"))
}

//基准推荐类
case class Recommendation(vid: Int, score: Double)

//用户推荐
case class UserRecs(uid: Int, recs: Seq[Recommendation])

//视频相似度推荐
case class VideoRecs(vid: Int, recs: Seq[Recommendation])


object StreamingRecommender {

    def main(args: Array[String]): Unit = {
        // 创建SparkConfig
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("StreamingRecommender")
        //创建SparkSession
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
        //获取SparkContext
        val sc = sparkSession.sparkContext
        //通过Spark上下文 获取流的上下文对象
        val streamingContext = new StreamingContext(sc, Seconds(2))
        // 数据库操作
        import sparkSession.implicits._


        // 加载视频相似度矩阵数据，然后广播到每个节点
        val simVideoMatrix = sparkSession
            .read
            .option("uri", "mongodb://localhost:27017/bilibili-recommender")
            .option("collection", "VideoRecs")
            .format("com.mongodb.spark.sql")
            .load()
            .as[VideoRecs]
            .rdd
            .map {
                videoRecs => {
                    (videoRecs.vid, videoRecs.recs.map(v => {
                        (v.vid, v.score)
                    }).toMap)
                }
            }
            .collectAsMap()

        //将视频相似度矩阵数据发布到每一个集群节点上
        val simVideoMatrixBroadCast = sc.broadcast(simVideoMatrix)

        //kafka连接参数
        val kafkaParams = Map(
            "bootstrap.servers" -> "hadoop2:9092",
            "key.deserializer" -> classOf[StringDeserializer],
            "value.deserializer" -> classOf[StringDeserializer],
            "group.id" -> "bilibili-recommender",
            "auto.offset.reset" -> "latest"
        )


        //通过kafka创建一个DirectStream
        val kafkaStream = KafkaUtils.createDirectStream(
            streamingContext,
            LocationStrategies.PreferConsistent,
            ConsumerStrategies.Subscribe[String, String](Array("bilibili-recommender"), kafkaParams)
        )

        //把原始数据LFMuid|LFMvid|score|timestamp 转换成评分流
        val ratingStream = kafkaStream.map {
            msg => {
                val attr = msg.value().split("\\|")
                (attr(0).toInt, attr(1).toInt, attr(2).toDouble, attr(3).toLong)
            }
        }


        //进行流式处理 核心实时算法部分
        ratingStream.foreachRDD{
           rdds => rdds.foreach{
               case(uid,vid,score,timestamp)=>{
                   println("rating data coming! =====================")
                   //1. 从redis获取当前用户的最近的k次评分，保存成Array[(mid, score)]
                   val userRecentlyRatings = getUserRecentlyRating(20, uid, ConnHelper.jedis)

                   userRecentlyRatings.foreach(item=>{
                       println(item)
                   })

                   println(userRecentlyRatings.size)

                   //2. 从相似度矩阵中取出当前电影最相似的N个电影，作为备选列表Array[mid]
                   val candidatevideos = getTopSimVideos(20, vid, uid, simVideoMatrixBroadCast.value)

                   //3. 对每个备选电影，计算推荐优先级，得到当前用户的实时推荐
                   val streamRecs = computeVideoScores(candidatevideos, userRecentlyRatings, simVideoMatrixBroadCast.value)

                   //4. 把推荐数据保存到mongodb
                   saveDataToMongoDB(uid, streamRecs)
               }
           }
        }

        // 开始接收和处理数据
        streamingContext.start();

        println(">>>>>>>>>>>>>> streaming started!")

        streamingContext.awaitTermination()
    }

    // 从用户最近的评分中取出N个评分
    def getUserRecentlyRating(num: Int, uid: Int, jedis: Jedis) ={
        println(1)
        jedis
            .lrange("uid:" + uid.toString, 0, num)
            .map {
                item => {
                    println(2)
                    val attr = item.split("\\:")
                    println(attr(0) + ":" + attr(1))
                    (attr(0).trim().toInt, attr(1).trim().toDouble)
                }
            }
            .toArray
    }

    //获取视频相似度矩阵中的前N个
    def getTopSimVideos(num: Int, vid: Int, uid: Int, simVideos: collection.Map[Int, Map[Int, Double]]) ={
        //1.从相似度矩阵中拿到所有的相似视频
        val allSimVideos = simVideos(vid).toArray

        //2.查询用户已经观看过的视频
        val ratingExist = ConnHelper
            .mongoClient("bilibili-recommender")("VideoRating")
            .find(MongoDBObject("LFMuid" -> uid))
            .toArray
            .map {
                item => {
                    item.get("LFMvid").toString.toInt
                }
            }

        //3. 把看过的视频从相似度矩阵中过滤掉，得到用户推荐列表
        allSimVideos
            .filter{
                video=>{
                    !ratingExist.contains(video)
                }
            }
            // 根据相似度矩阵的相似度排序
            .sortWith(_._2 > _._2)
            .take(num)
            .map{
                video => {
                    video._1
                }
            }
    }

    //获取两个视频间的相似度
    def getVideosSimScore(vid1 : Int, vid2 : Int, simVideos: collection.Map[Int, Map[Int, Double]]) ={

        simVideos.get(vid1) match {
            case Some(sims) => sims.get(vid2) match {
                case Some(score) => score
                case None => 0.0
            }
            case None => 0.0
        }
    }

    //自定义Log可以指定底数 进行超参数的调优
    //底数默认为10
    def log(m: Double) = {
        val N = 10
        math.log(m) / math.log(N)
    }

    // 计算备选视频的评分和优先级
    def computeVideoScores(candidateVideos: Array[Int], userRecentlyRatings: Array[(Int, Double)], simVideos: collection.Map[Int, Map[Int, Double]]) ={
        // 定义一个ArrayBuffer，用于保存每一个备选视频的基础得分
        val scores = collection.mutable.ArrayBuffer[(Int, Double)]()

        // 定义HashMap，保存每一个备选视频的增强减弱因子
        val increMap = collection.mutable.HashMap[Int, Int]()
        val decreMap = collection.mutable.HashMap[Int, Int]()

        for(candidateVideo <- candidateVideos; userRecentlyRating <- userRecentlyRatings){
            // 拿到备选视频和最近评分视频的相似度
            val simScore = getVideosSimScore(candidateVideo, userRecentlyRating._1, simVideos)

            if(simScore > 0.7){
                //计算备选视频的基础推荐得分
                scores += ((candidateVideo, simScore * userRecentlyRating._2))
                if (userRecentlyRating._2 > 4){
                    increMap(candidateVideo) = increMap.getOrDefault(candidateVideo, 0) + 1
                }else{
                    decreMap(candidateVideo) = decreMap.getOrDefault(candidateVideo, 0) + 1
                }
            }
        }

        //根据备选视频的vid做groupby, 根据公式去求最后的推荐评分
        //groupby之后的数据格式为 Map[Int, ArrayBuffer[(Int, Double)]]
        scores
            .groupBy(_._1)
            .map{
                case(vid, scoreList)=>{
                    (vid, scoreList.map(_._2).sum / scoreList.length + log(increMap.getOrDefault(vid, 1)) - log(decreMap.getOrDefault(vid, 1)))
                }
            }
            .toArray
            .sortWith(_._2 > _._2)

    }

    // 将StreamRecs存入数据库
    def saveDataToMongoDB(uid : Int, streamRecs: Array[(Int, Double)]): Unit ={
        val streamRecsCollection = ConnHelper.mongoClient("bilibili-recommender")("StreamRecs")

        // 如果表中已有uid对应的数据，则删除
        streamRecsCollection.findAndRemove(MongoDBObject("uid"->uid))

        streamRecsCollection.insert(
            MongoDBObject(
                "uid" -> uid,
                "recs" -> streamRecs.map{
                    video => {
                        MongoDBObject("vid" -> video._1, "score" -> video._2)
                    }
                }
            )
        )
    }

}
