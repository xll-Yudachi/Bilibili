package com.yudachi.processor.mq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UploadProcessTask {

    @Value("${FFMPEG_PATH}")
    public String ffmpeg_path;


}
