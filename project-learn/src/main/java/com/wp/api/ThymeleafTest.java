package com.wp.api;

import com.wp.util.GsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class ThymeleafTest {

    @GetMapping(path = "/thy")
    public ModelAndView thy(){
        ModelAndView modelAndView = new ModelAndView("common");
        Map<String, Object> param = new HashMap<>();
        param.put("theme","数据标准发布通知");
        param.put("desc","以下数据标准项通过数据管控平台正式发布:");
        param.put("url","http://192.168.2.68:9107/Home");
        List<List<String>> list = new ArrayList<>();
        param.put("data",list);
        List<String> title = new ArrayList<>();
        param.put("title",title);
        title.add("序号");
        title.add("主题");
        title.add("标准项名称");
        title.add("数据标准项管理部门");
        title.add("创建时间");
        List<String> data1 = new ArrayList<>();
        list.add(data1);
        data1.add("1");
        data1.add("测试主题");
        data1.add("测试标准");
        data1.add("测试部门");
        data1.add("2020.6.05");
        List<String> data2 = new ArrayList<>();
        list.add(data2);
        data2.add("2");
        data2.add("测试主题");
        data2.add("测试标准8");
        data2.add("测试部门5");
        data2.add("2020.6.08");
        modelAndView.addObject("email",param);
        System.out.println(GsonUtils.toJson(param));
        return modelAndView;
    }
}
