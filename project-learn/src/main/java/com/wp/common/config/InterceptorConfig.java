package com.wp.common.config;

import com.wp.common.interceptor.FirstInterceptor;
import com.wp.common.interceptor.SecondInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FirstInterceptor())
                //需要拦截的路径
                .addPathPatterns("/test/*")
                //不拦截的路径
                .excludePathPatterns("/test/druid")
                //数值越小先被执行
                .order(1);

        registry.addInterceptor(new SecondInterceptor())
                //需要拦截的路径
                .addPathPatterns("/test/*")
                //不拦截的路径
                .excludePathPatterns("/test/print")
                //数值越小先被执行
                .order(2);
    }
}
