package com.wp;

import static org.junit.Assert.assertTrue;

import com.google.gson.Gson;
import com.wp.pojo.bo.UserBO;
import com.wp.pojo.vo.UserVO;
import com.wp.util.GsonUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

/**
 * Unit test for simple App.
 */

public class ApplicationTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Gson gson = new Gson();
        UserBO userBO = new UserBO();
        userBO.setUserName("wp");
        userBO.setCreatTime(new Date());
        String json = "{\"userName\":\"wp\",\"userBirth\":null,\"creatTime\":\"2020-06-08 16:43:09\"}";
        Map userBO1 = GsonUtils.fromJson(json, Map.class);
        System.out.println(gson.toJson(userBO));
        System.out.println(GsonUtils.toJson(userBO));
        System.out.println(GsonUtils.toJson(userBO1));
    }
}
