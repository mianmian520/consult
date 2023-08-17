package com.boge.system.bean.dto;

import com.boge.core.common.annotation.mybatis.MyQuery;
import com.boge.core.common.annotation.mybatis.MySort;
import com.boge.core.common.base.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 标签表(Tag)实体类
 *
 * @author boge
 * @since 2023-08-8 08:55:11
 */
@Data
@ApiModel("标签表")
@MySort(fields = {"sort"}, methods = {1})
@EqualsAndHashCode(callSuper = true)
public class TagDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = 164334136184659925L;

    /**
     * 标签名称
     */
    @ApiModelProperty("标签名称")
    @NotBlank(message = "标签名称不能为空")
    @MyQuery(like = true)
    private String title;

    /**
     * 标签类型1、服务标签 2、行业标签 3、人物标签
     */
    @ApiModelProperty("标签类型1、服务标签 2、行业标签 3、人物标签")
    @MyQuery
    @NotNull(message = "标签类型不能为空")
    private Integer type;
}

