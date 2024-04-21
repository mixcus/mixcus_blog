package com.mixcus.service;


import com.mixcus.dao.UserDao;
import com.mixcus.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }
}

