package com.mixcus;

import com.mixcus.exception.test.ExceptionService;
import com.mixcus.pojo.UserInfo;
import com.mixcus.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserInfoService userService;

    @Autowired
    ExceptionService exceptionService;
    @Test
    void test(){
        List<UserInfo> userList = userService.getUserInfoList();
        for (UserInfo user : userList) {
            System.out.println(user);
        }

    }

    @Test
    void test2(){
        //exceptionService.badRequest();
        exceptionService.serverError();
    }


}
