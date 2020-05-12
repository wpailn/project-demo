package com.wp.service.impl;

import com.wp.dao.UserMapper;
import com.wp.pojo.dto.UserDTO;
import com.wp.pojo.entity.UserDO;
import com.wp.pojo.po.UserPO;
import com.wp.pojo.vo.UserVO;
import com.wp.service.UserService;
import com.wp.util.IdGeneratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVO userInfo(String userId) {
        UserPO userPO = userMapper.selectUser(userId);
        if(ObjectUtils.isEmpty(userPO)){
            return null;
        }else {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userPO,userVO);
            return userVO;
        }
    }

    @Override
    public Boolean register(UserDTO userDTO) {
        if(ObjectUtils.isEmpty(userDTO)){
            return false;
        }else {
            UserDO userDO = new UserDO();
            BeanUtils.copyProperties(userDTO,userDO);
            try {
                userDO.setUserBirth(DateUtils.parseDate(userDTO.getUserBirth(),"yyyy-MM-dd"));
            } catch (ParseException e) {
                log.info("用户出生日期错误");
            }
            userDO.setUserId(IdGeneratorUtils.UUID());
            userDO.setCreatTime(new Date());
            userMapper.insert(userDO);
            return true;
        }
    }

    @Override
    public List<String> allUserId() {
        return userMapper.allUserId();
    }
}
