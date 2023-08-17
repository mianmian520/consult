package com.boge.system.bean.dto;

import lombok.Data;

/**
 * 登录DTO
 * @Author boge
 * @Date 2022/9/15 0:22
 */
@Data
public class LoginDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}
