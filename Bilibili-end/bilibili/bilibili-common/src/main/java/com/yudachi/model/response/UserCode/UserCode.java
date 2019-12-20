package com.yudachi.model.response.UserCode;

import com.yudachi.model.response.ResultCode;
import lombok.ToString;

@ToString
public enum UserCode implements ResultCode {
    REGISTER_SUCCESS(true, 23000, "注册成功"),
    REGISTER_FAIL(false, 23001, "注册失败"),
    DUPLICATE_USERPHONE(false,23002,"手机号码重复"),
    DUPLICATE_USERNAME(false,23003,"用户名重复"),
    USERPHONE_SUCCESS(true, 23004, "手机号码正确"),
    USERNAME_SUCCESS(true, 23005, "用户名正确"),
    LOGIN_FAIL(false, 23006, "用户名或密码错误"),
    LOGIN_SUCCESS(true, 23007, "登录成功"),
    SEARCH_USERINFO_SUCCESS(true, 23008, "用户信息查询成功"),
    SEARCH_USERINFO_FAIL(false, 23009, "用户信息查询失败"),
    CHANGESIGN_FAIL(false, 23010, "修改个性签名失败"),
    CHANGESIGN_SUCCESS(true, 23011, "修改个性签名成功"),
    CODE_ERROR(false, 23012, "验证码错误");

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private UserCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}
