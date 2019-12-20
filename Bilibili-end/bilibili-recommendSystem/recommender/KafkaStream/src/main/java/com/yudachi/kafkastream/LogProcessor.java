package com.yudachi.kafkastream;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;

public class LogProcessor implements Processor<byte[], byte[]> {

    private ProcessorContext processorContext;

    @Override
    public void init(ProcessorContext processorContext) {
        this.processorContext = processorContext;
    }

    @Override
    public void process(byte[] key, byte[] value) {
        String input = new String(value);
        //根据前缀过滤日志信息，提取内容
        if (input.contains("VIDEO_RATING_PREFIX:")){
            System.out.println("video rating coming!!!" + input);
            input = input.split("VIDEO_RATING_PREFIX:")[1].trim();
            System.err.println(input);
            processorContext.forward("logProcessor".getBytes(), input.getBytes());
        }
    }

    @Override
    public void punctuate(long l) {

    }

    @Override
    public void close() {

    }
}
