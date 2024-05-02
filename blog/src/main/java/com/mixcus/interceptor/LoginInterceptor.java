package com.mixcus.interceptor;

import com.mixcus.utils.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    //方法前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        //通过请求头的Authorization属性获取token
        String token = request.getHeader("Authorization");

        try{

            Map<String, Object> claims = JWTUtil.parseToken(token);

            //没有异常则放行
            return true;

        }catch (Exception e){

            e.printStackTrace();
            response.setStatus(401);
            //表示拦截,不放行
            return false;
        }
    }
}

