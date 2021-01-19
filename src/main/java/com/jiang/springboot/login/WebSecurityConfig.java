package com.jiang.springboot.login;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * 登录配置
 */
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    public final static String SESSION_KEY = "username";

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("addInterceptors");
        InterceptorRegistration addInterceptor = registry.addInterceptor(
                this.getSecurityInterceptor());

        addInterceptor.addPathPatterns("/**")
                // 排除拦截器
                .excludePathPatterns("/static/**").excludePathPatterns(
                "/**/*.css").excludePathPatterns("/error").excludePathPatterns(
                "/img**").excludePathPatterns("/login**");
        // 添加拦截器
    }

    private static class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                                 Object handler)
                throws IOException {
            HttpSession session = request.getSession();

            System.out.println("preHandle -> " + session.getAttribute(SESSION_KEY));
            // 判断是否已有该用户登录的session
            if (session.getAttribute(SESSION_KEY) != null) {
                return true;
            }
            // 跳转到登录页
            String url = "/login";
            response.sendRedirect(url);
            return false;
        }
    }
}
