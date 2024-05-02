package com.mixcus.service;

import java.util.Map;

public interface UserService {

    String getPassword(String userName);

    int hasUserName(String userName);

    void addUser(String userName,String password);

    String getToken(String userName,Integer id);

    int getUserId(String userName);
}
