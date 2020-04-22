package com.wp.pojo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class User {
    @NotBlank(message = "userId 不能为空")
    private String userId;

    @NotBlank(message = "userName 不能为空")
    private String userName;

    @NotBlank(message = "userPassword 不能为空")
    private String userPassword;

    @NotBlank(message = "userEmail 不能为空")
    @Email(message = "email 格式不正确")
    private String userEmail;

    @NotBlank(message = "userBirth 不能为空")
    private Date userBirth;

    @NotBlank(message = "userPhone 不能为空")
    private String userPhone;

    private Date creatTime;

    private Date updateTime;
}