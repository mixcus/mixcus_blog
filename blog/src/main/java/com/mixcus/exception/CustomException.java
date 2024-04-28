package com.mixcus.exception;

import lombok.Getter;

/***
 * 自定义异常类
 */
@Getter
public class CustomException extends RuntimeException{
    private Integer code;
    private String msg;

    public CustomException() {
        super();
    }

    public CustomException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public CustomException(ErrorCode errorCode, String msg) {
        this.code = errorCode.getCode();
        this.msg = msg;
    }

}

