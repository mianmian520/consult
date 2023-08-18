package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 页面栏目表(PageBanner)实体类
 *
 * @author boge
 * @since 2023-08-17 18:00:50
 */
@Data
@ApiModel("页面栏目表")
@EqualsAndHashCode(callSuper = true)
public class PageBannerVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = -29850938593920745L;

    /**
     * 页面id
     */
    @ApiModelProperty("页面id")
    private Long pageId;

    /**
     * 栏目标题
     */
    @ApiModelProperty("栏目标题")
    private String title;

    /**
     * 栏目描述
     */
    @ApiModelProperty("栏目描述")
    private String description;

    /**
     * 顺序
     */
    @ApiModelProperty("顺序")
    private Integer sort;

    @ApiModelProperty("栏目项集合")
    private List<PageBannerItemVO> bannerItems;
}

