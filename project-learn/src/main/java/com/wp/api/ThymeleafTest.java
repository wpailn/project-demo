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

        modelAndView.addObject("emailMain",param);
        System.out.println(GsonUtils.toJson(param));
        return modelAndView;
    }
}
