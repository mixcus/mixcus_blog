package com.mixcus.controller;

import com.mixcus.pojo.UserInfo;
import com.mixcus.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userService;

    @RequestMapping("/getUserInfoList")
    public List<UserInfo> getUserInfoList(){
        return userService.getUserInfoList();
    }

}

