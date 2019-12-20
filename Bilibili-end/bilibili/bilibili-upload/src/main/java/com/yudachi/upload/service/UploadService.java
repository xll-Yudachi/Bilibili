package com.yudachi.upload.service;

import com.yudachi.model.request.video.VideoForm;
import com.yudachi.model.response.CommonCode;
import com.yudachi.model.response.ResponseResult;
import com.yudachi.model.response.VideoCode.VideoCode;
import com.yudachi.upload.entity.LFMVideo;
import com.yudachi.upload.entity.Video;
import com.yudachi.upload.entity.VideoMore;
import com.yudachi.upload.repository.LFMVideoRepository;
import com.yudachi.upload.repository.UploadRepository;
import com.yudachi.upload.repository.VideoInfoRepository;
import com.yudachi.upload.util.FdfsUtil;
import com.yudachi.utils.IdWorker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UploadService {

    @Value("${upload.mq.ex-media-processor}")
    private String ex_media_processor;
    @Value("${upload.mq.routingkey-media-video}")
    private String routingkey_media_video;
    @Value("${fdfs.webServerUrl}")
    private String webServerUrl;

    @Autowired
    private VideoInfoRepository videoInfoRepository;
    @Autowired
    private FdfsUtil fdfsUtil;
    @Autowired
    private UploadRepository uploadRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private LFMVideoRepository lfmVideoRepository;

    public ResponseResult uploadVideo(MultipartFile file) {

        String fileUrl = null;
        Video save = null;
        try {
            fileUrl = fdfsUtil.uploadFile(file);
            Video video = new Video();
            video.setId(idWorker.nextId() + "");
            video.setVideo_url(webServerUrl + fileUrl);
            save = uploadRepository.save(video);
            LFMVideo lfmVideo = new LFMVideo();
            lfmVideo.setId(idWorker.nextId() + "");
            lfmVideo.setVid(video.getId());
            lfmVideoRepository.save(lfmVideo);
            if (save == null) {
                return new ResponseResult(VideoCode.UPLOAD_FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,String> map = new HashMap<>();
        map.put("videoUrl", webServerUrl + fileUrl);
        map.put("videoId", save.getId());
        Sendm3u8MQ(map);
        return new ResponseResult(VideoCode.UPLOAD_SUCCESS, save.getId());
    }

    public ResponseResult uploadVideoInfo(VideoForm videoForm) {
        Video video = new Video();
        video.setId(videoForm.getId());
        video.setTitle(videoForm.getTitle());
        video.setUpid(videoForm.getUpid());
        video.setPartition_1(videoForm.getPartition_1());
        video.setPartition_2(videoForm.getPartition_2());
        video.setVideo_info(videoForm.getVideo_info());
        video.setUpload_time(new Date());
        video.setTag(videoForm.getTag());

        VideoMore videoMore = new VideoMore();
        videoMore.setId(idWorker.nextId() + "");
        videoMore.setVid(videoForm.getId());
        videoMore.setCopyright(videoForm.getCopyright());
        videoMore.setReprinted_url(videoForm.getReprinted_url());
        videoMore.setHms(videoForm.getHms());
        videoMore.setSubtitle(videoForm.getSubtitle());
        videoMore.setFans_post_subtitle(videoForm.getFans_post_subtitle());
        videoMore.setCcs(videoForm.getCcs());
        videoMore.setCcs_category_1(videoForm.getCcs_category_1());
        videoMore.setCcs_category_2(videoForm.getCcs_category_2());
        videoMore.setCcs_way(videoForm.getCcs_way());
        videoMore.setFans_dynamic(videoForm.getFans_dynamic());


        videoInfoRepository.save(videoMore);

        Optional<Video> tmp = uploadRepository.findById(videoForm.getId());
        if (tmp.isPresent()) {
            Video newVideo = tmp.get();
            video.setDuration(newVideo.getDuration());
            video.setImage_url(newVideo.getImage_url());
            video.setVideo_url(newVideo.getVideo_url());
            uploadRepository.save(video);
        } else {
            return new ResponseResult(VideoCode.UPLOAD_IMG_FAIL);
        }

        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Transactional
    public ResponseResult uploadVideoImg(String id, MultipartFile file) {

        String fileUrl = null;
        try {
            fileUrl = webServerUrl + fdfsUtil.uploadFile(file);
            Optional<Video> video = uploadRepository.findById(id);
            if (video.isPresent()) {
                Video newVideo = video.get();
                newVideo.setImage_url(fileUrl);
                uploadRepository.save(newVideo);
            } else {
                return new ResponseResult(VideoCode.UPLOAD_IMG_FAIL);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseResult(VideoCode.UPLOAD_IMG_FAIL);
        }


        return new ResponseResult(VideoCode.UPLOAD_IMG_SUCCESS, fileUrl);
    }


    /**
     * @Description //发送消息队列处理m3u8
     * @Params []
     * @Return void
     **/
    private void Sendm3u8MQ(Map<String,String> map) {
       rabbitTemplate.convertAndSend(ex_media_processor, routingkey_media_video, map);
    }
}
