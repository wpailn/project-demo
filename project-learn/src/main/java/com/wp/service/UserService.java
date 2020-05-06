package com.wp.service;

import com.wp.pojo.vo.UserVO;

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
}
