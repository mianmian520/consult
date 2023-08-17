package com.boge.system.controller;

import com.boge.core.common.exception.CustomException;
import com.boge.core.common.response.Result;
import com.boge.system.bean.dto.LoginDTO;
import com.boge.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器
 * @Author boge
 * @Date 2022/9/15 0:21
 */
@Api(tags = "登录控制器")
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * 登录
     * @param dto 请求参数
     */
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO dto) throws CustomException {
        return Result.success("登录成功", userService.login(dto));
    }

    /**
     * 登出
     */
    @ApiOperation("登出")
    @GetMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        return Result.success("登出成功", null);
    }

}
