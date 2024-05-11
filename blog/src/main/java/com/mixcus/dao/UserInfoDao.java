package com.mixcus.dao;

import com.mixcus.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoDao {
    List<UserInfo> getUserInfoList();
}
