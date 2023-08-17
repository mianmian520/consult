package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 职位表(Position)实体类
 *
 * @author boge
 * @since 2023-08-17 10:00:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_position")
public class PositionEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = 148615065396858572L;
    /**
     * 职位标题
     */
    private String title;
    /**
     * 职位职责
     */
    private String duty;
    /**
     * 职位要求
     */
    private String demand;
}

