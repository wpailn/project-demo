package com.wp.service;

import com.wp.pojo.dto.CommonPage;
import com.wp.pojo.dto.HandlerResult;
import com.wp.pojo.dto.UserDTO;
import com.wp.pojo.vo.UserVO;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 用户登录获取token
     * @param loginName 登录名
     * @param loginPass 登陆密码
     * @return token值
     */
    String userLogin(String loginName, String loginPass);

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
     * @param pageNum 页数
     * @param pageSize 每页数量
     * @return 用户id
     */
    HandlerResult<CommonPage<String>> allUserId(Integer pageNum, Integer pageSize);
}
