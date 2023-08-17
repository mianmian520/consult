package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
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
public class UserVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = 414163010480327886L;


    /**
     * 人员用户登录账号
     */
    private String userName;

    /**
     * 登录账号密码
     */
    private String password;
}

