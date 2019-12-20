import breeze.numerics.sqrt
import org.apache.spark.SparkConf
import org.apache.spark.mllib.recommendation.{ALS, MatrixFactorizationModel, Rating}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

/**
 * @Author Yudachi
 * @Description //模型评估和参数选取
 * @Date 2019/12/16 21:02
 * @Version 1.0
 **/
object ALSTrainer {

    def main(args: Array[String]): Unit = {
        // 创建SparkConf
        val sparkConf = new SparkConf().setAppName("ALSTrainer").setMaster("local[*]")

        //创建SparkSession
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

        //数据库操作
        import sparkSession.implicits._

        //加载评分数据
        val ratingRDD: RDD[Rating] = sparkSession
            .read
            .option("uri", "mongodb://localhost:27017/bilibili-recommender")
            .option("collection", "VideoRating")
            .format("com.mongodb.spark.sql")
            .load()
            .as[VideoRating]
            .rdd
            .map(rating => Rating(rating.LFMuid, rating.LFMvid, rating.score))
            .cache()

        //划分数据集和测试集
        val splits = ratingRDD.randomSplit(Array(0.8,0.2))

        //数据集
        val trainingRDD: RDD[Rating] = splits(0)
        //测试集
        val testingRDD: RDD[Rating] = splits(1)

        //输出最优参数
        adjustALSParams(trainingRDD, testingRDD)

        //关闭Spark
        sparkSession.close()
    }


    //计算出最小均方根误差的参数
    def adjustALSParams(trainData: RDD[Rating], testData: RDD[Rating]): Unit ={
        val result = for (rank <- Array(20,50,100,200); lambda <- Array(1, 0.1, 0.01, 0.001))
            yield {
                val model: MatrixFactorizationModel = ALS.train(trainData, rank,5, lambda)
                val rmse = getRMSE(model, testData)
                (rank, lambda, rmse)
            }

        //按照均方根误差排序
        println(result.minBy(_._3))

    }

    // 计算均方根误差
    def getRMSE(model: MatrixFactorizationModel, testData: RDD[Rating]): Double ={
        // 计算预测评分
        val userProducts = testData.map(item=>(item.user, item.product))
        val predictRating = model.predict(userProducts)

        //((uid,vid),(实际,测试))
        val test = testData.map(item=>((item.user, item.product), item.rating))
        val predict = predictRating.map(item=>((item.user, item.product), item.rating))

        //均方根误差
        sqrt(
            //内连接取并集
            test
                .join(predict)
                .map{
                    case ((uid, vid),(actual, pre))=>{
                        val err = actual - pre
                        err * err
                    }
                    //取平均值
                }.mean()
        )

    }
}
