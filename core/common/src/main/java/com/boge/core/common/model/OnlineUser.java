package com.boge.core.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

/**
 * 在线用户
 * @Author boge
 * @Date 2022/9/14 23:31
 */
@Data
public class OnlineUser {

    private Long id;

    /**
     * 人员用户登录账号
     */
    private String userName;

    /**
     * token值
     */
    private String token;
}
