package com.wp.util;

import cn.hutool.core.util.IdUtil;
import org.springframework.util.IdGenerator;

import java.util.UUID;

public class IdGeneratorUtils {
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
