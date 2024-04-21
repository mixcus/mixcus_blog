package com.mixcus;

import com.mixcus.pojo.User;
import com.mixcus.service.UserService;
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
    UserService userService;

    @Test
    void test(){
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

    }

}
