package com.yudachi.media.controller;

import com.yudachi.media.entity.Danmu;
import com.yudachi.media.entity.Video;
import com.yudachi.media.service.DanmuService;
import com.yudachi.media.service.MediaService;
import com.yudachi.model.response.CommonCode;
import com.yudachi.model.response.Media.CategoryResult;
import com.yudachi.model.response.Media.CommercialResult;
import com.yudachi.model.response.Media.CommercialWayResult;
import com.yudachi.model.response.Media.LanguageResult;
import com.yudachi.model.response.ResponseResult;
import com.yudachi.model.response.VideoCode.VideoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media")
@CrossOrigin
public class MediaController {

    @Autowired
    private MediaService mediaService;
    @Autowired
    private DanmuService danmuService;

    @GetMapping("/initCategory")
    public ResponseResult initCategory(){
        List<CategoryResult> list = mediaService.initCategoryList();
        return new ResponseResult(CommonCode.SUCCESS, list);
    }

    @GetMapping("/findVideoUrlById")
    public ResponseResult findVideoUrlById(@RequestParam("id") String id){
        String url = mediaService.findVideoUrlById(id);
        return new ResponseResult(CommonCode.SUCCESS, url);
    }

    @GetMapping("/initLanguage")
    public ResponseResult initLanguage(){
        List<LanguageResult> list = mediaService.initLanguage();
        return new ResponseResult(CommonCode.SUCCESS, list);
    }

    @GetMapping("/initCommercial")
    public ResponseResult initCommercial(){
        List<CommercialResult> list = mediaService.initCommercial();
        return new ResponseResult(CommonCode.SUCCESS, list);
    }

    @GetMapping("/initCommercialWay")
    public ResponseResult initCommercialWay(){
        List<CommercialWayResult> list = mediaService.initCommercialWay();
        return new ResponseResult(CommonCode.SUCCESS, list);
    }

    @GetMapping("/findVideoById")
    public ResponseResult findVideoById(@RequestParam("id") String id){
        Video video = mediaService.findVideoById(id);
        if (video == null){
            return new ResponseResult(VideoCode.NO_EXIST_FILE);
        }else{
            return new ResponseResult(CommonCode.SUCCESS, video);
        }
    }

    @GetMapping("/findDanmuByPlayer")
    public ResponseResult findDanmuByPlayer(@RequestParam("player") String player){
        List<Danmu> list = danmuService.findDanmuByPlayer(player);
        if (list.size() <= 0){
            return new ResponseResult(CommonCode.FAIL, null);
        }else{
            return new ResponseResult(CommonCode.SUCCESS, list);
        }
    }

    @GetMapping("/findDanmuByAuthor")
    public ResponseResult findDanmuByAuthor(@RequestParam("author") String author){
        List<Danmu> list = danmuService.findDanmuByAuthor(author);
        if (list.size() <= 0){
            return new ResponseResult(CommonCode.FAIL, null);
        }else{
            return new ResponseResult(CommonCode.SUCCESS, list);
        }
    }

    @GetMapping("/findOrderByDateTop12")
    public ResponseResult findOrderByDateTop10(@RequestParam("player") String player){
        List<Danmu> list = danmuService.findOrderByDateTop12(player);
        if (list.size() <= 0){
            return new ResponseResult(CommonCode.FAIL, null);
        }else{
            return new ResponseResult(CommonCode.SUCCESS, list);
        }
    }
}
