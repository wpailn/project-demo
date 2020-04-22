package com.wp.pojo.dto;

import lombok.Data;

@Data
public class HandlerResult<T> {
    private boolean success;
    private int code;
    private String msg;
    private T data;
}
