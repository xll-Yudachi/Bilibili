package com.yudachi.model.response.CommentCode;

import com.yudachi.model.response.ResultCode;
import lombok.ToString;

@ToString
public enum CommentCode implements ResultCode {
    FIND_SUCCESS(true, 26000, "查询成功"),
    FIND_FAIL(false, 26001, "查询失败，暂无数据");

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private CommentCode(boolean success, int code, String message) {
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
