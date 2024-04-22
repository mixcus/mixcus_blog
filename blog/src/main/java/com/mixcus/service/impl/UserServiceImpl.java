package com.mixcus.service.impl;

import com.mixcus.dao.UserDao;
import com.mixcus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

