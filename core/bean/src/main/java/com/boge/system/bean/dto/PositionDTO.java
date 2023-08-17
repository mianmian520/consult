package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 职位表(Position)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:52
 */
@Data
@ApiModel("职位表")
@EqualsAndHashCode(callSuper = true)
public class PositionDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -73160975468191657L;


    /**
     * 职位标题
     */
    @ApiModelProperty("职位标题")
    private String title;

    /**
     * 职位职责
     */
    @ApiModelProperty("职位职责")
    private String duty;

    /**
     * 职位要求
     */
    @ApiModelProperty("职位要求")
    private String demand;
}

