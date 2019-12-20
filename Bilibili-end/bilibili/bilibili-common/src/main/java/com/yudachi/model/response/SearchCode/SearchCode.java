package com.yudachi.model.response.SearchCode;

import com.yudachi.model.response.ResultCode;
import lombok.ToString;

@ToString
public enum SearchCode implements ResultCode {
    SEARCH_SUCCESS(true, 25000, "查询成功"),
    SEARCH_FAIL(false, 25001, "查询失败，暂无数据");

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private SearchCode(boolean success, int code, String message) {
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
