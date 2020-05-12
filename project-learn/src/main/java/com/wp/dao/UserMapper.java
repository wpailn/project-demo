package com.wp.dao;

import com.wp.pojo.entity.UserDO;
import com.wp.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户dao
 */
@Mapper
public interface UserMapper {
    /**
     * 根据userId查询数据库中用户信息
     * @param userId 用户主键
     * @return 用户信息
     */
    UserPO selectUser(@Param("userId")String userId);

    /**
     * 查询所有用户id
     * @return 所有用户id
     */
    List<String> allUserId();

    /**
     * 用户信息新增
     * @param userDO 用户新增信息
     */
    void insert(UserDO userDO);
}