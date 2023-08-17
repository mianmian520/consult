package com.boge.system.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 页面(Page)实体类
 * @Author boge
 * @Date 2023/8/17 21:35
 */
@Data
@ApiModel(value = "页面对象")
public class PageVO {

    @ApiModelProperty("页面id")
    private Long id;

    @ApiModelProperty("页面标题")
    private String title;

    @ApiModelProperty("轮播栏目")
    private PageBannerVO banner;

    @ApiModelProperty("第一项之后的栏目")
    private List<PageBannerVO> secondBanners;
}
