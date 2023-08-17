package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 简历表(CurriculumVitae)实体类
 *
 * @author boge
 * @since 2023-08-17 10:00:16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_curriculum_vitae")
public class CurriculumVitaeEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = 893800238768552887L;
    /**
     * 职位id
     */
    private Long positionId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 时间
     */
    private Date time;
}

