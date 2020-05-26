package com.wp.pojo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity(name = "用户实体类")
@Table(name = "t_user",schema = "wpailn")
public class UserDO {

    @Id
    @Column(name = "user_id", unique = true, nullable = false, columnDefinition = "主键")
    private String userId;

    @Column(name = "user_name", unique = true, nullable = false, columnDefinition = "用户名")
    private String userName;

    @Column(name = "user_password", nullable = false, columnDefinition = "用户密码")
    private String userPassword;

    @Column(name = "user_email", nullable = false, columnDefinition = "用户邮箱")
    private String userEmail;

    @Column(name = "user_birth", nullable = false, columnDefinition = "用户出生日期")
    private Date userBirth;

    @Column(name = "user_phone", nullable = false, columnDefinition = "用户手机号码")
    private String userPhone;

    @Column(name = "creat_time", nullable = false, columnDefinition = "创建日期")
    private Date creatTime;

    @Column(name = "update_time",columnDefinition = "更新日期")
    private Date updateTime;
}