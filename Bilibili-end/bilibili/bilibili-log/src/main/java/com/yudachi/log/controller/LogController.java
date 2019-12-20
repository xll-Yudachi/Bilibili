package com.yudachi.log.controller;

import com.yudachi.log.entity.UserRecord;
import com.yudachi.log.entity.Video;
import com.yudachi.log.service.LogService;
import com.yudachi.model.response.CommonCode;
import com.yudachi.model.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/changeUserRecord")
    public ResponseResult changeUserRecord(@RequestBody UserRecord userRecord){
        System.out.println(userRecord);
        logService.changeUserRecord(userRecord);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @GetMapping("/initRecommender")
    public ResponseResult initRecommender(@RequestParam("uid") String uid){
        List<Video> list = logService.findByUid(uid);
        return new ResponseResult(CommonCode.SUCCESS, list);
    }

    @GetMapping("/initTagsRecommender")
    public ResponseResult initTagsRecommender(@RequestParam("vid") String vid){
        List<Video> list = logService.tagsRelatedRecommend(vid);
        return new ResponseResult(CommonCode.SUCCESS, list);
    }

    @GetMapping("/initNewUserRecommender")
    public ResponseResult initNewUserRecommender(){
        List<Video> list = logService.initNewUserRecommender();
        return new ResponseResult(CommonCode.SUCCESS, list);
    }
}
