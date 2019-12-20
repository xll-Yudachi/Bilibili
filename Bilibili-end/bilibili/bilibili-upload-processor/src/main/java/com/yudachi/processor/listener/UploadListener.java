package com.yudachi.processor.listener;

import com.yudachi.processor.entity.M3u8;
import com.yudachi.processor.entity.Video;
import com.yudachi.processor.repository.M3u8Repository;
import com.yudachi.processor.repository.VideoRepository;
import com.yudachi.utils.HLSVideoUtil;
import com.yudachi.utils.IdWorker;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@RabbitListener(queues = {"queue_media_video_processor"})
public class UploadListener {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${upload.mq.queue-media-video-processor}")
    private String queue_media_video_processor;
    @Value("${FFMPEG_PATH}")
    private String ffmpeg_path;
    @Value("${m3u8folder_path}")
    private String m3u8folder_path;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private M3u8Repository m3u8Repository;
    @Autowired
    private VideoRepository videoRepository;

    @RabbitHandler
    public void uploadListener(Map<String,String> map){
        String videoId = map.get("videoId");
        String videoUrl = map.get("videoUrl");
        String m3u8ID = idWorker.nextId() + "";
        HLSVideoUtil videoUtil = new HLSVideoUtil(ffmpeg_path, videoUrl, videoId + ".m3u8", m3u8folder_path + videoId + "/");
        String res = videoUtil.generateM3u8();

        if ("success".equals(res)){
            M3u8 m3u8 = new M3u8();
            m3u8.setId(m3u8ID);
            m3u8.setVideoid(videoId);
            m3u8.setM3u8_url(m3u8folder_path + videoId + "/" + videoId + ".m3u8");
            m3u8Repository.save(m3u8);
        }
        Optional<Video> optionalVideo = videoRepository.findById(videoId);
        if (optionalVideo.isPresent()){
            Video video = optionalVideo.get();
            video.setDuration(videoUtil.getVideoTime(videoUrl));
            videoRepository.save(video);
        }
    }

}
