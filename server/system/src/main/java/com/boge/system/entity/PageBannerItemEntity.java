package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * 页面栏目配置表(PageBannerItem)实体类
 *
 * @author boge
 * @since 2023-08-17 18:01:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_page_banner_item")
public class PageBannerItemEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -97542436458853165L;
    /**
     * 栏目id
     */
    private Long bannerId;
    /**
     * 内容名称
     */
    private String contentTitle;
    /**
     * 内容描述
     */
    private String contentDesc;
    /**
     * 初始效果图
     */
    private Long initImage;
    /**
     * 焦点效果图
     */
    private Long focusImage;
    /**
     * 连接类型 1、案例 2、观点 3、资讯 4、职位
     */
    private Integer connectType;
    /**
     * 连接内容id 根据类型来判断数据来源
     */
    private Long connectId;

    /**
     * 顺序
     */
    private Integer sort;

}

