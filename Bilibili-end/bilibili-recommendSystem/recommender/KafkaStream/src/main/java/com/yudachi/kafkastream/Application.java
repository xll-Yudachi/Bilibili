package com.yudachi.kafkastream;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.TopologyBuilder;

import java.util.Properties;

public class Application {
    public static void main(String[] args) {

        //定义连接
        //kafka
        String brokers = "hadoop2:9092";
        //zk
        String zookeepers = "hadoop2:2181";

        //定义输入和输出的topic
        String from ="log";
        String to = "bilibili-recommender";

        //定义kafka streaming的配置
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "logFilter");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        properties.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, zookeepers);
        properties.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG,"2");
        properties.put(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG, MyEventTimeExtractor.class);

        StreamsConfig config = new StreamsConfig(properties);

        //拓扑构建器
        TopologyBuilder builder = new TopologyBuilder();

        //定义流处理的拓扑结构
        builder.addSource("SOURCE", from)
               .addProcessor("PROCESS", LogProcessor::new, "SOURCE")
                .addSink("SINK", to, "PROCESS");

        KafkaStreams streams = new KafkaStreams(builder, config);

        streams.start();

        System.err.println("kafkaStream starting!!!");
    }
}
