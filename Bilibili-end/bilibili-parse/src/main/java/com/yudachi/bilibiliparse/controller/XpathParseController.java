package com.yudachi.bilibiliparse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xpath")
public class XpathParseController {

    @GetMapping("test")
    public String test(){
        return "success";
    }
}
