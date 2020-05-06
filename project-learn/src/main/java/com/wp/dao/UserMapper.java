package com.wp.dao;

import com.wp.pojo.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    UserDO selectUser(@Param(value = "userId")String userId);
}