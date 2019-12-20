package com.yudachi.model.response.VideoCode;

import com.yudachi.model.response.ResultCode;
import lombok.ToString;

@ToString
public enum VideoCode implements ResultCode {
    UPLOAD_FAIL(false, 24000, "文件上传失败"),
    UPLOAD_SUCCESS(true,24001,"文件上传成功"),
    UPLOAD_IMG_FAIL(false, 24002, "图片上传失败"),
    UPLOAD_IMG_SUCCESS(true,24003,"图片上传成功"),
    NO_EXIST_FILE(false, 2004, "文件不存在");
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private VideoCode(boolean success, int code, String message) {
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
