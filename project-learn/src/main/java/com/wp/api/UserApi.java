package com.wp.api;

import com.wp.pojo.entity.UserDO;
import com.wp.pojo.dto.HandlerResult;
import com.wp.pojo.dto.UserDTO;
import com.wp.pojo.vo.UserVO;
import com.wp.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
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

    @RequestMapping(path = "/allUserId",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户id", notes = "不需要参数")
    public HandlerResult<List<String>> allUserId(){
        List<String> list = userService.allUserId();
        if(CollectionUtils.isEmpty(list)){
            return HandlerResult.failed("无数据");
        }else {
            return HandlerResult.success(list);
        }
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    @ApiOperation(value = "用户注册", notes = "以json格式发送数据")
    public HandlerResult register(@ApiParam(value = "用户注册信息") @RequestBody @Valid UserDTO user){
        Boolean result = userService.register(user);
        if(result){
            return HandlerResult.success("注册成功");
        }else {
            return HandlerResult.failed("注册失败");
        }
    }

    @RequestMapping(path = "/userInfo",method = RequestMethod.GET)
    @ApiOperation(value = "用户查询", notes = "查询参数为用户id")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userId", value = "用户id",required = true,paramType = "form",dataType = "String")
    )
    public HandlerResult<UserVO> userInfo(@Valid @RequestParam(value = "userId") @NotBlank String userId){
        UserVO userVO = userService.userInfo(userId);
        if (ObjectUtils.isEmpty(userVO)){
            return HandlerResult.failed("用户信息查询错误");
        }else {
            return HandlerResult.success(userVO,"用户信息查询成功");
        }
    }
}
