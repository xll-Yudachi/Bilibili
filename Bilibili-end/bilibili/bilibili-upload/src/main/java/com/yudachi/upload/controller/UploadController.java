package com.yudachi.upload.controller;

import com.yudachi.model.request.video.VideoForm;
import com.yudachi.model.response.ResponseResult;
import com.yudachi.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {

    @Value("${FFMPEG_PATH}")
    private String FFMPEG_PATH;
    @Autowired
    private UploadService uploadService;

    /**
     * @Author Yudachi
     * @Description //上传视频
     * @Date 2019/12/6 17:03
     * @Version 1.0
     **/
    @PostMapping("/video")
    public ResponseResult uploadVideo(@RequestBody MultipartFile file){
        return uploadService.uploadVideo(file);
    }

    @PostMapping("/videoImg/{id}")
    public ResponseResult uploadVideoImg(@PathVariable("id") String id, @RequestBody MultipartFile file){
        return uploadService.uploadVideoImg(id, file);
    }

    @PostMapping("/videoInfo")
    public ResponseResult uploadVideoInfo(@RequestBody VideoForm videoForm){
        return uploadService.uploadVideoInfo(videoForm);
    }
}
