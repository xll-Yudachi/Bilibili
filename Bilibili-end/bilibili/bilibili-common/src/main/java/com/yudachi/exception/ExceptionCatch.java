package com.yudachi.exception;

import com.google.common.collect.ImmutableMap;
import com.yudachi.model.response.CommonCode;
import com.yudachi.model.response.ResponseResult;
import com.yudachi.model.response.ResultCode;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Yudachi
 * @Description 统一异常捕获类
 * @Date 2019/11/10 17:45
 * @Version 1.0
 **/
@ControllerAdvice   //控制器增强
public class ExceptionCatch {

    //谷歌的ImmutableMap是线程安全且不可修改的map
    private  static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    //定义map对象的Builder对象，去构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> Builder = new ImmutableMap.Builder<>();

    //捕获CustomException此类异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException){
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception){
        if (EXCEPTIONS == null){
            EXCEPTIONS = Builder.build();
        }
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null){
            return new ResponseResult(resultCode);
        }else{
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }

    static {
        //在这里加入一些基础的异常类型判断
        Builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);
    }

}
