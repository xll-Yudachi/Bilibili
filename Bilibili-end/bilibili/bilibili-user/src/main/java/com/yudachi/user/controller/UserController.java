package com.yudachi.user.controller;

import com.yudachi.model.response.CommonCode;
import com.yudachi.model.response.ResponseResult;
import com.yudachi.user.entity.User;
import com.yudachi.user.service.SmsService;
import com.yudachi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * @Author Yudachi
 * @Description 用户服务控制层
 * @Date 2019/11/11 18:24
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SmsService smsService;

    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user, @RequestParam("code") String code) {
        return userService.register(user, code);
    }


    @GetMapping("/findUserByPhone")
    public ResponseResult findUserByPhone(String phone){
        return userService.findUserByPhone(phone);
    }

    @GetMapping("/findUserByUsername")
    public ResponseResult findUserByUsername(String username){
        return userService.findUserByUsername(username);
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return userService.login(user);
    }

    @GetMapping("/getUserInfo")
    public ResponseResult getUserInfo(String userId){
        return userService.getUserInfo(userId);
    }

    @PutMapping("/changeSign")
    public ResponseResult changeSign(String uid, String sign){
        return userService.changeSign(uid,sign);
    }

    @GetMapping("/sendRegisterSms")
    public ResponseResult sendRegisterSms(@PathParam("phone") String phone){
       smsService.sendRegisterSms(phone);
       return new ResponseResult(CommonCode.SUCCESS);
    }
}
