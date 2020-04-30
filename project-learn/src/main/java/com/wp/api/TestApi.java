package com.wp.api;

import com.google.gson.Gson;
import com.wp.common.config.ehcache.EhcacheManager;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
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

    @Value("${mas.url}")
    private String masUrl;

    @Resource
    private DataSource dataSource;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private EhcacheManager ehcacheManager;


    @RequestMapping(path = "/all",method = RequestMethod.POST)
    public void all(){
        Cache<String,String> cache = ehcacheManager.getCacheManager().getCache("cache1",String.class,String.class);
        cache.put("123","wp");
        System.out.println(cache.get("123"));
    }

    @RequestMapping(path = "/druid",method = RequestMethod.POST)
    public void druid(){
    }

    @RequestMapping(path = "/print",method = RequestMethod.POST)
    public void print(){
    }

}
