package com.mixcus.service.impl;

import com.mixcus.dao.UserDao;
import com.mixcus.service.UserService;
import com.mixcus.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String getPassword(String userName) {

        return userDao.getPassword(userName);
    }

    @Override
    public int hasUserName(String userName) {

        return userDao.hasUserName(userName);
    }

    @Override
    public void addUser(String userName, String password) {
        userDao.addUser(userName,password);
    }

    @Override
    public int getUserId(String userName) {
        return userDao.getUserId(userName);
    }

    @Override
    public String getToken(String userName,Integer id) {

        Map<String,Object> claims = new HashMap<>();


        return JWTUtil.getToken(claims);
    }


}

