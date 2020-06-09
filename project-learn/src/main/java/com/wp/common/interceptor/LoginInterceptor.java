package com.wp.common.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wp.common.annotation.CheckToken;
import com.wp.dao.UserMapper;
import com.wp.exception.AuthorityException;
import com.wp.pojo.dto.HandlerResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();
        //检查是否有CheckToken注释，没有则跳过认证
        if(!method.isAnnotationPresent(CheckToken.class)){
            return true;
        }
        CheckToken checkToken = method.getAnnotation(CheckToken.class);
        if (!checkToken.required()){
            return true;
        }
        //需要校验token
        String headerToken = request.getHeader("token");
        if(StringUtils.isBlank(headerToken)){
            throw new AuthorityException(HandlerResult.failed("token校验失败"));
        }
        //登录账户
        String loginName;
        try {
            loginName = JWT.decode(headerToken).getAudience().get(0);
        } catch (JWTDecodeException e) {
            throw new AuthorityException(HandlerResult.failed("token校验失败"));
        }
        if (StringUtils.isBlank(loginName)){
            throw new AuthorityException(HandlerResult.failed("token校验失败"));
        }
        //用户密码
        String userPassword = userMapper.selectPassword(loginName);
        if (StringUtils.isBlank(userPassword)){
            throw new AuthorityException(HandlerResult.failed("token校验失败"));
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userPassword)).build();
        try {
            jwtVerifier.verify(headerToken);
        } catch (JWTVerificationException e) {
            throw new AuthorityException(HandlerResult.failed("token校验失败"));
        }
        return true;
    }
}
