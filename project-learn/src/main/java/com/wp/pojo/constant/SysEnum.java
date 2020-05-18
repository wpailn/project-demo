package com.wp.pojo.constant;

import lombok.Getter;

@Getter
public enum  SysEnum {
    USER("USER","用户前缀"),
    ROLE("ROLE","角色前缀"),
    ;
    private String value;
    private String desc;

    SysEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
