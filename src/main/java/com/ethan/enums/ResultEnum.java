package com.ethan.enums;

/**
 * Created by Ethan L X Gu on 2017/3/20.
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1, "unknown error"),
    PRIMARY_SCHOOL(100, "Primary school"),
    MIDDLE_SCHOOL(101, "middle school"),
    SUCCESS(0, "success");

    private Integer code;

    private String msg;

    ResultEnum(final Integer code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
