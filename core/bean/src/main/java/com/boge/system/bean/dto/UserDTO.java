package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.io.Serializable;

/**
 * 系统管理-人员表(User)实体类
 *
 * @author boge
 * @since 2023-08-8 08:24:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -68114320505618487L;


    /**
     * 人员用户登录账号
     */
    private String userName;

    /**
     * 登录账号密码
     */
    private String password;
}

