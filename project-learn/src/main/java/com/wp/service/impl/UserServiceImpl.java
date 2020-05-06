package com.wp.service.impl;

import com.wp.dao.UserMapper;
import com.wp.pojo.entity.UserDO;
import com.wp.pojo.vo.UserVO;
import com.wp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVO userInfo(String userId) {

        return null;
    }
}
