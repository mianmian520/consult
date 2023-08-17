package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 标签表(Tag)实体类
 *
 * @author boge
 * @since 2023-08-8 08:34:50
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_tag")
public class TagEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -75224046207520304L;
    /**
     * 标签名称
     */
    private String title;
    /**
     * 标签类型1、服务标签 2、行业标签 3、人物标签
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;
}

