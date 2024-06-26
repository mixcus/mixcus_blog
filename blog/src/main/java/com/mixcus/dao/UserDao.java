package com.mixcus.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    String getPassword(@Param("userName") String userName);

    int hasUserName(@Param("userName") String userName);

    void addUser(@Param("userName") String userName,@Param("password") String password);

    int getUserId(@Param("userName") String userName);

}
