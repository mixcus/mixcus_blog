package com.mixcus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class UserDto implements Serializable {
    //用户id
    private Integer userId;
    //用户账号名
    private String username;
    //用户令牌
    private String token;
}

