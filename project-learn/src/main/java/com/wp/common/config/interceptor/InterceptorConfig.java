package com.wp.common.config.interceptor;

import com.wp.common.interceptor.FirstInterceptor;
import com.wp.common.interceptor.LoginInterceptor;
import com.wp.common.interceptor.SecondInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(firstInterceptor())
                //需要拦截的路径
                .addPathPatterns("/test/*")
                //不拦截的路径
                .excludePathPatterns("/test/druid")
                //数值越小先被执行
                .order(1);

        registry.addInterceptor(secondInterceptor())
                //需要拦截的路径
                .addPathPatterns("/test/*")
                //不拦截的路径
                .excludePathPatterns("/test/print")
                //数值越小先被执行
                .order(2);

        registry.addInterceptor(loginInterceptor())
                //需要拦截的路径
                .addPathPatterns("/user/*")
                //不拦截的路径
                .excludePathPatterns("/test/print")
                //数值越小先被执行
                .order(3);
    }

    @Bean
    public FirstInterceptor firstInterceptor(){
        return new FirstInterceptor();
    }

    @Bean
    public SecondInterceptor secondInterceptor(){
        return new SecondInterceptor();
    }

    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
}
