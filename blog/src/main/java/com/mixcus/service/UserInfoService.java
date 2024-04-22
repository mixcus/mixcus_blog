package com.mixcus.service;

import com.mixcus.pojo.UserInfo;


import java.util.List;

public interface UserInfoService {
    List<UserInfo> getUserInfoList();
    //根据用户名获取密码
}
