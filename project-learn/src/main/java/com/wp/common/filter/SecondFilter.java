package com.wp.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Slf4j
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        log.info("初始化过滤器SecondFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("SecondFilter拦截请求");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器SecondFilter");
    }
}
