package com.yudachi.search.controller;


import com.yudachi.model.response.ResponseResult;
import com.yudachi.model.response.Search.SearchResult;
import com.yudachi.model.response.SearchCode.SearchCode;
import com.yudachi.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    public ResponseResult findVideoByKeyWord(@RequestParam("keyword") String keyword){
        List<SearchResult> list = searchService.findAllVideo(keyword);

        if (list.size() <= 0){
            return new ResponseResult(SearchCode.SEARCH_FAIL, null);
        }else{
            return new ResponseResult(SearchCode.SEARCH_SUCCESS, list);
        }
    }

    @GetMapping("/searchByPage")
    public ResponseResult findVideoByKeyWord(@RequestParam("keyword") String keyword, @RequestParam("page") String page){
        List<SearchResult> list = searchService.findVideoByPage(keyword, page);

        if (list.size() <= 0){
            return new ResponseResult(SearchCode.SEARCH_FAIL, null);
        }else{
            return new ResponseResult(SearchCode.SEARCH_SUCCESS, list);
        }
    }
}
