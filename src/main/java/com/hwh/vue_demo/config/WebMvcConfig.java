package com.hwh.vue_demo.config;

import com.hwh.vue_demo.controller.interceptor.ResultInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 拦截器暂时没有用
 * @Author hwh
 * @Date 2020/3/2 21:43
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ResultInterceptor resultInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(resultInterceptor).addPathPatterns("/**");
    }
}
