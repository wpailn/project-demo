package com.wp;


import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.*;

public class CommonTest {

    @Test
    public void common(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("userId","U001");
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<Map> responseEntity = restTemplate.exchange("http://localhost:18080/semf/token",
                HttpMethod.POST,requestEntity,Map.class);
        System.out.println(new Gson().toJson(responseEntity.getBody()));
    }

    @Test
    public void test(){
        User user = new User();
        user.setAge(100);
        user.setName("王朋");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);
        ResponseEntity<User> responseEntity = restTemplate.exchange("http://localhost:8082/email/test1",
                HttpMethod.POST,requestEntity,User.class);
        System.out.println(Objects.requireNonNull(responseEntity.getBody()).toString());
    }

    @Data
    @NoArgsConstructor
    static class User{
        private String name;
        private Integer age;
        private int agw1;
    }
}
