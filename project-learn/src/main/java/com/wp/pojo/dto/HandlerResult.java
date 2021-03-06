package com.wp.pojo.dto;

import com.wp.service.BaseCode;
import com.wp.pojo.constant.CommonCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "应答数据")
public class HandlerResult<T> {

    @ApiModelProperty(value = "应答码")
    private String code;

    @ApiModelProperty(value = "应答信息")
    private String msg;

    @ApiModelProperty(value = "应答数据")
    private T data;

    /**
     * 成功返回信息
     */
    public static <T> HandlerResult<T> success() {
        return new HandlerResult<>(CommonCode.A0000.getCode(), CommonCode.A0000.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> HandlerResult<T> success(T data) {
        return new HandlerResult<>(CommonCode.A0000.getCode(), CommonCode.A0000.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> HandlerResult<T> success(T data, String message) {
        return new HandlerResult<>(CommonCode.A0000.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param baseCode 错误码
     */
    public static <T> HandlerResult<T> failed(BaseCode baseCode) {
        return new HandlerResult<>(baseCode.getCode(), baseCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param baseCode 错误码
     * @param message 错误信息
     */
    public static <T> HandlerResult<T> failed(BaseCode baseCode,String message) {
        return new HandlerResult<>(baseCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> HandlerResult<T> failed(String message) {
        return new HandlerResult<>(CommonCode.B0001.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> HandlerResult<T> failed() {
        return failed(CommonCode.B0001);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> HandlerResult<T> validateFailed() {
        return failed(CommonCode.A0402);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> HandlerResult<T> validateFailed(String message) {
        return new HandlerResult<>(CommonCode.A0402.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> HandlerResult<T> unauthorized(T data) {
        return new HandlerResult<>(CommonCode.A0200.getCode(), CommonCode.A0200.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> HandlerResult<T> forbidden(T data) {
        return new HandlerResult<>(CommonCode.A0301.getCode(), CommonCode.A0301.getMessage(), data);
    }

}
