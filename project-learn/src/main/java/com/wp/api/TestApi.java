package com.wp.api;

import com.google.gson.Gson;
import com.wp.common.config.ehcache.EhcacheManager;
import com.wp.common.listener.PublishEvent;
import com.wp.service.UserService;
import com.wp.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@RestController
@RequestMapping(path = "/test")
@Slf4j
@ApiIgnore
public class TestApi {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private EhcacheManager ehcacheManager;

    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public void all(){
        Cache<String,String> cache = ehcacheManager.getCacheManager().getCache("foo",String.class,String.class);
        cache.put("123","wp");
        System.out.println(cache.get("123"));
    }

    @RequestMapping(path = "/testListener")
    public void testListener(){
        applicationContext.publishEvent(new PublishEvent(this,"ln"));
    }
}
