package com.mixcus.config;

import com.mixcus.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置类
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //添加拦截器对象
    @Autowired
    private LoginInterceptor loginInterceptor;

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(loginInterceptor)
               //配置不需要拦截的路径
               .excludePathPatterns("/login","/register");
    }

}

