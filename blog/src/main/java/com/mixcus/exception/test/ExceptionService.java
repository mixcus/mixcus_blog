package com.mixcus.exception.test;

import com.mixcus.exception.CustomException;
import com.mixcus.exception.ErrorCode;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    //测试异常
    public void serverError() {
        try {
            Class.forName("com.mysql.XXX.Driver");
        } catch (Exception e) {
            throw new CustomException(ErrorCode.SERVER_ERROR, "数据库驱动加载异常，出现ClassNotFoundException，请联系管理员");
        }
    }

    public void badRequest() {
        throw new CustomException(ErrorCode.BAD_REQUEST, "您输入的数据不符合业务逻辑，请确认后重新输入!");
    }

}

