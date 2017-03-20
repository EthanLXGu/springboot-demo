package com.ethan.exception;

import com.ethan.enums.ResultEnum;

/**
 * Created by Ethan L X Gu on 2017/3/20.
 */
public class GirlException extends RuntimeException{
    private Integer code;

//    public GirlException(Integer code, String message) {
//        super(message);
//        this.code = code;
//    }

    public GirlException(final ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }
}
