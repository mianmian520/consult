package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 页面栏目配置表(PageBannerItem)实体类
 *
 * @author boge
 * @since 2023-08-17 18:00:50
 */
@Data
@ApiModel("页面栏目配置表")
@EqualsAndHashCode(callSuper = true)
public class PageBannerItemDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -14371168243586962L;


    /**
     * 栏目id
     */
    @ApiModelProperty("栏目id")
    @NotNull(message = "栏目项id不能为空")
    private Long bannerId;

    /**
     * 内容名称
     */
    @ApiModelProperty("内容名称")
    private String contentTitle;

    /**
     * 内容描述
     */
    @ApiModelProperty("内容描述")
    private String contentDesc;

    /**
     * 初始效果图
     */
    @ApiModelProperty("初始效果图")
    private Long initImage;

    /**
     * 焦点效果图
     */
    @ApiModelProperty("焦点效果图")
    private Long focusImage;

    /**
     * 连接类型 1、案例 2、观点 3、资讯 4、职位
     */
    @ApiModelProperty("连接类型 1、案例 2、观点 3、资讯 4、职位")
    private Integer connectType;

    /**
     * 连接内容id 根据类型来判断数据来源
     */
    @ApiModelProperty("连接内容id 根据类型来判断数据来源")
    private Long connectId;

    /**
     * 顺序
     */
    @ApiModelProperty("顺序")
    private Integer sort;

    @ApiModelProperty("预留字段1")
    private String reserve1;

    @ApiModelProperty("预留字段2")
    private String reserve2;

    @ApiModelProperty("连接内容路由")
    private String connectPath;
}

