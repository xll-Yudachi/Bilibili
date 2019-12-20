package com.yudachi.model.response;

/**
 * @Author Yudachi
 * @Description
 * 10000 -- 通用错误代码
 * 22000 -- 媒资错误代码
 * 23000 -- 用户中心错误代码
 * 24000 -- cms错误代码
 * 25000 -- 文件系统错误代码
 * @Date 2019/11/10 17:39
 * @Version 1.0
 **/
public interface ResultCode {
    //操作是否成功
    boolean success();
    //操作代码
    int code();
    //提示信息
    String message();
}
