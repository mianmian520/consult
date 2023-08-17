package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 系统管理-人员表(User)实体类
 *
 * @author boge
 * @since 2023-08-8 08:25:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
public class UserEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = 15482557577520759L;
    /**
     * 人员用户登录账号
     */
    private String userName;
    /**
     * 登录账号密码
     */
    private String password;
}

