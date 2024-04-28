package com.mixcus.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/***
 * 拦截异常，并封装成统一的数据返回格式AjaxResponse
 */
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse<?> customerException(CustomException e) {
        return AjaxResponse.error(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse<?> exception(Exception e) {
        return AjaxResponse.error(new CustomException(ErrorCode.UNKNOWN));
    }

}

