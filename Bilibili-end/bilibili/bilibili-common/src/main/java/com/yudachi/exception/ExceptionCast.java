package com.yudachi.exception;

import com.yudachi.model.response.ResultCode;

/**
 * @Author Yudachi
 * @Description 异常抛出类
 * @Date 2019/11/10 17:45
 * @Version 1.0
 **/
public class ExceptionCast {
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
