package com.wp.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@ApiModel(value = "用户", description = "用户注册信息")
public class UserDTO {

    @NotBlank(message = "userName 不能为空")
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    @NotBlank(message = "userPassword 不能为空")
    @ApiModelProperty(value = "用户密码", required = true)
    private String userPassword;

    @NotBlank(message = "userEmail 不能为空")
    @Email(message = "email 格式不正确")
    @ApiModelProperty(value = "用户邮箱", required = true)
    private String userEmail;

    @NotBlank(message = "userBirth 不能为空")
    @ApiModelProperty(value = "用户出生日期", required = true)
    private String userBirth;

    @NotBlank(message = "userPhone 不能为空")
    @ApiModelProperty(value = "用户手机号码", required = true)
    private String userPhone;
}
