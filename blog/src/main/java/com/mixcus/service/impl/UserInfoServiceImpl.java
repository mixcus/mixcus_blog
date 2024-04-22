package com.mixcus.service.impl;


import com.mixcus.dao.UserInfoDao;
import com.mixcus.pojo.UserInfo;
import com.mixcus.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userDao;

    @Override
    public List<UserInfo> getUserInfoList() {
        return userDao.getUserInfoList();
    }
}

