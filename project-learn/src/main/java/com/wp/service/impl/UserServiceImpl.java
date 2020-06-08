package com.wp.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wp.dao.UserMapper;
import com.wp.pojo.constant.SysEnum;
import com.wp.pojo.dto.UserDTO;
import com.wp.pojo.entity.UserDO;
import com.wp.pojo.bo.UserBO;
import com.wp.pojo.vo.UserVO;
import com.wp.service.UserService;
import com.wp.util.IdGeneratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource(name = "redisTemplateString")
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String userLogin(String loginName, String loginPass) {
        Integer num = userMapper.checkUserExist(loginName,loginPass);
        if(num == 1){
            //登陆成功，生成token放入redis缓存
            String token = JWT.create().withAudience(loginName)
                    .sign(Algorithm.HMAC256(loginPass));
            redisTemplate.opsForValue().set(SysEnum.USER.getValue()+loginName,token,10, TimeUnit.MINUTES);
            return token;
        }else {
            return null;
        }
    }

    @Override
    public UserVO userInfo(String userId) {
        UserBO userBO = userMapper.selectUser(userId);
        if(ObjectUtils.isEmpty(userBO)){
            return null;
        }else {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userBO,userVO);
            return userVO;
        }
    }

    @Override
    @Transactional
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
