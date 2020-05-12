package com.wp.pojo.po;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户简要信息
 */
@Getter
@Setter
public class UserPO {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户出生日期
     */
    private Date userBirth;

    /**
     * 用户注册日期
     */
    private Date creatTime;
}
