package com.wp.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandlerResult<T> {
    private boolean success;
    private int code;
    private String msg;
    private T data;
}
