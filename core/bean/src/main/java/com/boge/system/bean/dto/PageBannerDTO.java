package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 页面栏目表(PageBanner)实体类
 *
 * @author boge
 * @since 2023-08-17 18:00:50
 */
@Data
@ApiModel("页面栏目表")
@EqualsAndHashCode(callSuper = true)
public class PageBannerDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -26589750880448898L;


    /**
     * 页面id
     */
    @ApiModelProperty("页面id")
    @NotNull(message = "页面id不能为空")
    private Long pageId;

    /**
     * 栏目标题
     */
    @ApiModelProperty("栏目标题")
    @NotBlank(message = "栏目标题不能为空")
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
}

