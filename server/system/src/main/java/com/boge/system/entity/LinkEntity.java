package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 友链管理(Link)实体类
 *
 * @author boge
 * @since 2023-09-20 14:49:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_link")
public class LinkEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -22893833994955889L;
    /**
     * 名称
     */
    private String name;
    /**
     * 地址
     */
    private String url;
}

