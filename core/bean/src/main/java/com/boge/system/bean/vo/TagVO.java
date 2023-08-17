package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 标签表(Tag)实体类
 *
 * @author boge
 * @since 2023-08-8 08:55:11
 */
@Data
@ApiModel("标签表")
@EqualsAndHashCode(callSuper = true)
public class TagVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = -79091948626022948L;


    /**
     * 标签名称
     */
    @ApiModelProperty("标签名称")
    private String title;

    /**
     * 标签类型1、服务标签 2、行业标签 3、人物标签
     */
    @ApiModelProperty("标签类型1、服务标签 2、行业标签 3、人物标签")
    private Integer type;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;
}

