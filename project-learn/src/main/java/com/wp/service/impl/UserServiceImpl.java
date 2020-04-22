package com.wp.service.impl;

import com.wp.dao.UserMapper;
import com.wp.pojo.domain.User;
import com.wp.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<String> selectAllUserId() {
        List<User> userList = userMapper.select();
        List<String> list = userList.stream().map(User::getUserId).collect(Collectors.toList());
        return list;
    }
}
