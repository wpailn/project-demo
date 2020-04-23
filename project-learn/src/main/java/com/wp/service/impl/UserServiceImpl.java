package com.wp.service.impl;

import com.wp.dao.UserMapper;
import com.wp.exception.NullDataException;
import com.wp.pojo.domain.UserDO;
import com.wp.pojo.dto.HandlerResult;
import com.wp.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<String> selectAllUserId() {
        int i = 6/0;
        List<UserDO> userList = userMapper.select();
        List<String> list = userList.stream().map(UserDO::getUserId).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(list)){
            throw new NullDataException(new HandlerResult<>(false,500,"数据为空",null));
        }
        return list;
    }
}
