package com.wp.common.config.filter;

import com.wp.common.filter.FirstFilter;
import com.wp.common.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;

@Configuration
public class FilterConfig {

    @Resource
    private FirstFilter firstFilter;

    @Resource
    private SecondFilter secondFilter;

    @Bean
    public FilterRegistrationBean<FirstFilter> setUpMyFilter() {
        FilterRegistrationBean<FirstFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        //数值越小先被执行
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setFilter(firstFilter);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Collections.singletonList("/test/*")));
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> setUpMyFilter2() {
        FilterRegistrationBean<SecondFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        //数值越小先被执行
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.setFilter(secondFilter);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Collections.singletonList("/test/*")));
        return filterRegistrationBean;
    }
}
