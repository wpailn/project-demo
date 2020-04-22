package com.wp.pojo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Date userBirth;

    private String userPhone;

    private Date creatTime;

    private Date updateTime;
}