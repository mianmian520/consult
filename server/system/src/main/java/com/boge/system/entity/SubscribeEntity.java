package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约表(Subscribe)实体类
 *
 * @author boge
 * @since 2023-08-17 10:00:20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_subscribe")
public class SubscribeEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -70556193759608824L;
    /**
     * 名称
     */
    private String name;
    /**
     * 公司
     */
    private String company;
    /**
     * 服务
     */
    private String server;
    /**
     * 预算
     */
    private String budget;
    /**
     * 联系
     */
    private String telephone;
    /**
     * 邮件
     */
    private String email;
    /**
     * 预约时间
     */
    private Date time;
}

