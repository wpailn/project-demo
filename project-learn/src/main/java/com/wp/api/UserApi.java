package com.wp.api;

import com.wp.pojo.domain.UserDO;
import com.wp.pojo.dto.HandlerResult;
import com.wp.pojo.dto.UserDTO;
import com.wp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
@Slf4j
@Api(tags = "用户相关接口")
@Validated
public class UserApi {

    @Resource
    private UserService userService;

    @RequestMapping(path = "/allUserId",method = RequestMethod.POST)
    @ApiOperation(value = "查询所有用户id", notes = "不需要参数")
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

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    @ApiOperation(value = "用户注册", notes = "以json格式发送数据")
    public HandlerResult register(@RequestBody @Valid UserDTO user){
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(user,userDO);
        System.out.println("");
        return null;
    }

    @RequestMapping(path = "/userInfo",method = RequestMethod.POST)
    @ApiOperation(value = "用户查询", notes = "查询参数为用户id")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userId", value = "用户id",required = true,paramType = "form",dataType = "String")
    )
    public HandlerResult userInfo(@Valid @RequestParam(value = "userId") @NotBlank String userId){
        return null;
    }
}
