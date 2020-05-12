package com.wp.service;

import com.wp.pojo.dto.UserDTO;
import com.wp.pojo.vo.UserVO;

import java.util.List;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 根据userId查询用户信息
     * @param userId 用户id
     * @return 用户展示信息
     */
    UserVO userInfo(String userId);

    /**
     * 用户注册
     * @param userDTO 用户注册信息
     * @return 注册结果
     */
    Boolean register(UserDTO userDTO);

    /**
     * 查询所有用户id
     * @return 所有用户id
     */
    List<String> allUserId();
}
