package com.yudachi.processor.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //交换机
    public static final String EX_MEDIA_PROCESSTASK = "ex_media_processor";
    //视频处理队列
    @Value("${upload.mq.queue-media-video-processor}")
    public String queue_media_video_processor;
    //视频处理路由
    @Value("${upload.mq.routingkey-media-video}")
    public String routingkey_media_video;

    /**
     * @Author Yudachi
     * @Description //交换机配置
     * @Date 2019/12/8 22:09
     * @Version 1.0
     **/
    @Bean(EX_MEDIA_PROCESSTASK)
    public Exchange EX_MEDIA_VIDEOTASK(){
        return ExchangeBuilder.directExchange(EX_MEDIA_PROCESSTASK).durable(true).build();
    }

    /**
     * @Author Yudachi
     * @Description //声明队列
     * @Date 2019/12/8 23:07
     * @Version 1.0
     **/
    @Bean("queue_media_video_processor")
    public Queue QUEUE_PROCESSTASK(){
        Queue queue = new Queue(queue_media_video_processor, true, false, false);
        return queue;
    }

    /**
     * @Author Yudachi
     * @Description // 绑定队列到交换机
     * @Date 2019/12/8 23:11
     * @Version 1.0
     **/
    @Bean
    public Binding binding_queue_media_processtask(@Qualifier("queue_media_video_processor") Queue queue, @Qualifier(EX_MEDIA_PROCESSTASK) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingkey_media_video).noargs();
    }

    // 消费者并发数量
    public static final int DEFAULT_CONCURRENT = 10;

    public SimpleRabbitListenerContainerFactory containerFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(DEFAULT_CONCURRENT);
        factory.setMaxConcurrentConsumers(DEFAULT_CONCURRENT);
        configurer.configure(factory, connectionFactory);
        return factory;
    }

}
