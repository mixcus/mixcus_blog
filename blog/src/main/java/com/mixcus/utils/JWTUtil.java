package com.mixcus.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtil {

    //设置密钥名字
    private final static String KEY = "MIXCUS";

    //获取token
    public static String getToken(Map<String,Object> claims){
        //参数为封装了用户信息的map集合
        return JWT.create()
                .withClaim("claims",claims)
                //实则token过期时间(这里设置毫秒)
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*20*60))
                //加密
                .sign(Algorithm.HMAC256(KEY));
    }

    //解析token
    public static Map<String,Object> parseToken(String token){
        //通过密钥取解析token
        return JWT.require(Algorithm.HMAC256(KEY))
                //获取一个JWT验证器
                .build()
                //获取解析后的JWT
                .verify(token)
                //通过指定的claims获取map集合
                .getClaim("claims")
                .asMap();
    }

}

