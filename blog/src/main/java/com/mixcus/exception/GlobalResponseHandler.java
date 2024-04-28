package com.mixcus.exception;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@ControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (returnType.getMethod() == null) {
            return false;
        }
        ResponseBody responseBody = returnType.getMethod().getAnnotation(ResponseBody.class);
        if (responseBody != null) {
            return true;
        }
        // 只拦截返回结果为 AjaxResponse 类型
        return returnType.getMethod().getReturnType() == AjaxResponse.class;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        ResponseBody responseBody = returnType.getMethod().getAnnotation(ResponseBody.class);
        if (responseBody != null || selectedContentType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)) {
            if (body instanceof AjaxResponse<?> ajaxBody) {
                if (!Objects.equals(ajaxBody.getCode(), ErrorCode.UNKNOWN.getCode())) {
                    response.setStatusCode(HttpStatus.valueOf(ajaxBody.getCode()));
                }
            } else {
                return AjaxResponse.success(body);
            }
        }
        return body;
    }
}

