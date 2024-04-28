package com.mixcus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class UserInfo {
    private Integer userId;

    private String userName;

    private Integer userAge;

    private Instant birthday;

    private String phone;

    private String email;

    private Instant registerTime;
}

