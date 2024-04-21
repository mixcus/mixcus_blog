package com.mixcus.controller;

import com.mixcus.pojo.User;
import com.mixcus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserList")
    public List<User> getUserList(){
        return userService.getUserList();
    }

}

