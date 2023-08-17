package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言表(LeaveWord)实体类
 *
 * @author boge
 * @since 2023-08-17 10:00:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_leave_word")
public class LeaveWordEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -69484780838894638L;
    /**
     * 称呼
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 留言
     */
    private String leaveWord;
    /**
     * 网址
     */
    private String website;
    /**
     * 留言时间
     */
    private Date time;
}

