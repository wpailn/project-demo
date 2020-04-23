package com.wp.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
@RequestMapping(path = "/test")
public class TestApi {

    @Resource
    private DataSource dataSource;

    @RequestMapping(path = "/all")
    public void all(){
    }

    @RequestMapping(path = "/druid")
    public void druid(){
    }

    @RequestMapping("/print")
    public void print(){
    }
}
