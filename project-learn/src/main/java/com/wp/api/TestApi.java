package com.wp.api;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/test")
@Slf4j
public class TestApi {

    @Resource
    private DataSource dataSource;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(path = "/all",method = RequestMethod.POST)
    public void all(){
    }

    @RequestMapping(path = "/druid",method = RequestMethod.POST)
    public void druid(){
    }

    @RequestMapping(path = "/print",method = RequestMethod.POST)
    public void print(){
    }

    @RequestMapping(path = "mas",method = RequestMethod.GET)
    public void mas(){
        Gson gson = new Gson();
        Map openResult;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("userId", "U001");
            List<String> list = new ArrayList<>();
            list.add("123456");
            HttpEntity<String> requestEntity = new HttpEntity<>(gson.toJson(list), headers);
            ResponseEntity<Map> responseEntity = restTemplate.exchange("http://192.168.2.68:9107/api/api/act/started",
                    HttpMethod.POST,requestEntity,Map.class);

            openResult = responseEntity.getBody();

            log.info("主数据回调应答报文======>{}",gson.toJson(openResult));
        } catch (RestClientException e) {
            e.printStackTrace();
            log.error("主数据回调接口异常");
        }
    }
}
