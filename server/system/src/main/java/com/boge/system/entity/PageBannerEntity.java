package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 页面栏目表(PageBanner)实体类
 *
 * @author boge
 * @since 2023-08-17 18:01:06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_page_banner")
public class PageBannerEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = 272347244672518895L;
    /**
     * 页面id
     */
    private Long pageId;
    /**
     * 栏目标题
     */
    private String title;
    /**
     * 栏目描述
     */
    private String description;
    /**
     * 顺序
     */
    private Integer sort;
}

