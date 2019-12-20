package com.yudachi.user.service;


import com.yudachi.user.utils.GenerateUtil;
import com.yudachi.user.utils.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Value("${SMS.APP_ID}")
    private Integer appid;
    @Value("${SMS.APP_KEY}")
    private String appkey;
    @Value("${SMS.NATION_CODE}")
    private String nationCode;
    @Value("${SMS.TEMPLATE_ID}")
    private Integer templateId;
    @Value("${SMS.SIGN}")
    private String sign;

    public void sendRegisterSms(String phone) {
        String code = GenerateUtil.generateCode();
        System.err.println(code);
        redisTemplate.opsForValue().set(phone, code);
        SMSUtil.sendSms(code, appid, appkey, nationCode, phone, templateId, sign);
    }

}
