package com.mixcus.dao;

import com.mixcus.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoDao {

    List<UserInfo> getUserInfoList();
}
