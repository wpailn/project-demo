package com.wp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.ObjectUtils;

/**
 * Gson工具类
 */
public class GsonUtils {
    /**
     * 饿汉式创建单例Gson格式化时间
     */
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();

    /**
     * 实体类转json字符串
     * @param object 实体类
     * @return json字符串
     */
    public static String toJson(Object object){
        if(ObjectUtils.isEmpty(object)){
            return null;
        }
        return gson.toJson(object);
    }

    /**
     * json字符串转实体类
     * @param string json字符串
     * @param cl 实体类型
     * @param <T> 泛型
     * @return 实体类
     */
    public static<T> T fromJson(String string, Class<T> cl){
        if(ObjectUtils.isEmpty(string) || ObjectUtils.isEmpty(cl)){
            return null;
        }
        return gson.fromJson(string,cl);
    }
}
