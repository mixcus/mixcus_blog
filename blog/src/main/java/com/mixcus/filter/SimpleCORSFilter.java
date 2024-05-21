package com.mixcus.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SimpleCORSFilter implements Filter {
    private static final String ALLOWED_ORIGINS = "allowedOrigins";
    private static final String ALLOWED_METHODS = "allowedMethods";
    private static final String ALLOWED_HEADERS = "allowedHeaders";
    private static final String MAX_AGE = "maxAge";

    // 通过配置获取允许的来源、方法、头部和最大年龄
    // 这里仅作演示，实际应用中应从配置文件或环境变量中获取
    private  String[] allowedOrigins = {"http://localhost:5173"};
    private String[] allowedMethods = {"POST", "GET", "OPTIONS", "DELETE", "HEAD", "PUT"};
    private String[] allowedHeaders = {"authority", "content-type", "version-info", "X-Requested-With","Authorization"};
    private String maxAge = "3600";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 实际应用中，这里会从配置文件或环境变量中加载允许的来源、方法、头部和最大年龄
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 根据配置设置跨域请求的相应头
        response.setHeader("Access-Control-Allow-Origin", getOrigin(request));
        response.setHeader("Access-Control-Allow-Methods", String.join(", ", allowedMethods));
        response.setHeader("Access-Control-Max-Age", maxAge);
        response.setHeader("Access-Control-Allow-Headers", String.join(", ", allowedHeaders));

        if ("OPTIONS".equals(request.getMethod())) {
            // 对于OPTIONS请求，直接返回204
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // 销毁时的操作（如果有的话）
    }

    // 根据请求Origin决定是否允许访问，示例中简化为固定允许的来源
    private String getOrigin(HttpServletRequest request) {
        String origin = request.getHeader("Origin");
        for (String allowedOrigin : allowedOrigins) {
            if (origin != null && origin.equals(allowedOrigin)) {
                return origin;
            }
        }
        // 如果没有匹配的允许来源，可以返回null或"-"表示不允许跨域访问
        return "-";
    }
}

