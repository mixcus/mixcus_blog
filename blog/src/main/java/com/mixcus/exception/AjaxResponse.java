package com.mixcus.exception;
import lombok.Data;

/***
 * 统一数据响应
 * @param <T>
 */
@Data
public class AjaxResponse<T> {

    private String message;//信息

    private Integer code;//状态码

    private T data;//数据

    public static AjaxResponse<?> error(CustomException e) {
        AjaxResponse<?> response = new AjaxResponse<>();
        response.setCode(e.getCode());
        response.setMessage(e.getMsg());
        return response;
    }

    public static AjaxResponse<?> success() {
        AjaxResponse<?> response = new AjaxResponse<>();
        response.setCode(ErrorCode.SUCCESS.getCode());
        response.setMessage(ErrorCode.SUCCESS.getMsg());
        return response;
    }
    public static <T> AjaxResponse<T> success(T data) {
        AjaxResponse<T> response = new AjaxResponse<>();
        response.setCode(ErrorCode.SUCCESS.getCode());
        response.setMessage(ErrorCode.SUCCESS.getMsg());
        response.setData(data);
        return response;
    }
}

