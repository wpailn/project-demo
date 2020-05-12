package com.wp.util;

import java.util.UUID;

public class IdGeneratorUtils {
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
