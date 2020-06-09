package com.wp.api;

import com.wp.common.annotation.CheckToken;
import com.wp.pojo.dto.HandlerResult;
import com.wp.pojo.dto.UserDTO;
import com.wp.pojo.vo.UserVO;
import com.wp.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
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

    @PostMapping(path = "/login")
    @ApiOperation(value = "用户登录获取token", notes = "需要登录名和密码")
    @CheckToken(required = false)
    public HandlerResult<String> login(@RequestParam(value = "loginName") String loginName,
                                       @RequestParam(value = "loginPass") String loginPass){
        String token = userService.userLogin(loginName, loginPass);
        if (StringUtils.isBlank(token)){
            return HandlerResult.failed("登陆失败");
        }else {
            return HandlerResult.success(token);
        }

    }

    @GetMapping(path = "/allUserId")
    @ApiOperation(value = "查询所有用户id", notes = "不需要参数")
    @CheckToken
    public HandlerResult<List<String>> allUserId(){
        List<String> list = userService.allUserId();
        if(CollectionUtils.isEmpty(list)){
            return HandlerResult.failed("无数据");
        }else {
            return HandlerResult.success(list);
        }
    }

    @PostMapping(path = "/register")
    @ApiOperation(value = "用户注册", notes = "以json格式发送数据")
    @CheckToken
    public HandlerResult register(@ApiParam(value = "用户注册信息") @RequestBody @Valid UserDTO user, BindingResult bindingResult){
        Boolean result = userService.register(user);
        if(result){
            return HandlerResult.success("注册成功");
        }else {
            return HandlerResult.failed("注册失败");
        }
    }

    @GetMapping(path = "/userInfo")
    @ApiOperation(value = "用户查询", notes = "查询参数为用户id")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userId", value = "用户id",required = true,paramType = "form",dataType = "String")
    )
    @CheckToken
    public HandlerResult<UserVO> userInfo(@Valid @RequestParam(value = "userId") @NotBlank(message = "userId不能为空") String userId){
        UserVO userVO = userService.userInfo(userId);
        if (ObjectUtils.isEmpty(userVO)){
            return HandlerResult.failed("用户信息查询错误");
        }else {
            return HandlerResult.success(userVO,"用户信息查询成功");
        }
    }
}
