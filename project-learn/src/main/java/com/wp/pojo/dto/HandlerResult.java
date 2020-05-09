package com.wp.pojo.dto;

import com.wp.service.BaseCode;
import com.wp.service.impl.CommonCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "应答数据")
public class HandlerResult<T> {
    @ApiModelProperty(value = "应答状态")
    private boolean success;

    @ApiModelProperty(value = "应答码")
    private long code;

    @ApiModelProperty(value = "应答信息")
    private String msg;

    @ApiModelProperty(value = "应答数据")
    private T data;

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> HandlerResult<T> success(T data) {
        return new HandlerResult<T>(true, CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> HandlerResult<T> success(T data, String message) {
        return new HandlerResult<T>(true, CommonCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param baseCode 错误码
     */
    public static <T> HandlerResult<T> failed(BaseCode baseCode) {
        return new HandlerResult<T>(false, baseCode.getCode(), baseCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param baseCode 错误码
     * @param message 错误信息
     */
    public static <T> HandlerResult<T> failed(BaseCode baseCode,String message) {
        return new HandlerResult<T>(false, baseCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> HandlerResult<T> failed(String message) {
        return new HandlerResult<T>(false, CommonCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> HandlerResult<T> failed() {
        return failed(CommonCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> HandlerResult<T> validateFailed() {
        return failed(CommonCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> HandlerResult<T> validateFailed(String message) {
        return new HandlerResult<T>(false, CommonCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> HandlerResult<T> unauthorized(T data) {
        return new HandlerResult<T>(false, CommonCode.UNAUTHORIZED.getCode(), CommonCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> HandlerResult<T> forbidden(T data) {
        return new HandlerResult<T>(false, CommonCode.FORBIDDEN.getCode(), CommonCode.FORBIDDEN.getMessage(), data);
    }

}
