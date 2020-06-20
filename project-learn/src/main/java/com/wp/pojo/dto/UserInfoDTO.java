package com.wp.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户信息",description = "用户展示信息")
public class UserInfoDTO {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户出生日期")
    private String userBirth;

    @ApiModelProperty(value = "用户注册日期")
    private String creatTime;
}
