package com.yudachi.exception;

import com.yudachi.model.response.ResultCode;

/**
 * @Author Yudachi
 * @Description //用户自定义异常类
 * @Date 2019/11/10 17:36
 * @Version 1.0
 **/
public class CustomException extends RuntimeException{
    public ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
