package com.boge.system.bean.dto;

import com.boge.core.common.annotation.mybatis.MyQuery;
import com.boge.core.common.base.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 友链管理(Link)实体类
 *
 * @author boge
 * @since 2023-09-20 14:48:54
 */
@Data
@ApiModel("友链管理")
@EqualsAndHashCode(callSuper = true)
public class LinkDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = 423572062103528719L;

    /**
     * 名称
     */
    @NotBlank(message = "友链名称不能为空")
    @ApiModelProperty("名称")
    @MyQuery(like = true)
    private String name;

    /**
     * 地址
     */
    @NotBlank(message = "友链地址不能为空")
    @ApiModelProperty("地址")
    private String url;
}

