package com.mixcus.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    private boolean flag;//执行结果，true为执行成功 false为执行失败

    private String message;//返回结果信息，主要用于页面提示信息

    private Object data;//返回数据

    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result(String message) {
        this.message = message;
    }

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

}

