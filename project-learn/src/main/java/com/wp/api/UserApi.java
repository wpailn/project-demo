package com.wp.api;

import com.wp.pojo.dto.HandlerResult;
import com.wp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
@Slf4j
public class UserApi {

    @Resource
    private UserService userService;

    @RequestMapping(path = "/allUserId")
    public HandlerResult allUserId(){
        HandlerResult<List<String>> handlerResult = new HandlerResult<>();
        List<String> list = userService.selectAllUserId();
        if(CollectionUtils.isEmpty(list)){
            handlerResult.setMsg("数据查询失败");
        }else {
            handlerResult.setData(list);
        }
        return handlerResult;
    }
}
