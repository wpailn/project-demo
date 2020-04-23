package com.wp.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "应答数据")
public class HandlerResult<T> {
    @ApiModelProperty(value = "应答状态")
    private boolean success;

    @ApiModelProperty(value = "应答码")
    private int code;

    @ApiModelProperty(value = "应答信息")
    private String msg;

    @ApiModelProperty(value = "应答数据")
    private T data;
}
