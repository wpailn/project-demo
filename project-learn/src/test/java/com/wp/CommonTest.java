package com.wp;


import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class CommonTest {

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
        System.out.println(responseEntity.getBody().toString());
    }

    @Data
    @NoArgsConstructor
    static class User{
        private String name;
        private Integer age;
    }
}
