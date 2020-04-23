package com.wp.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
@RequestMapping(path = "/test")
public class TestApi {

    @Resource
    private DataSource dataSource;

    @RequestMapping(path = "/all",method = RequestMethod.POST)
    public void all(){
    }

    @RequestMapping(path = "/druid",method = RequestMethod.POST)
    public void druid(){
    }

    @RequestMapping(path = "/print",method = RequestMethod.POST)
    public void print(){
    }
}
