package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 观点-标签表(ViewPointTag)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:54
 */
@Data
@ApiModel("观点-标签表")
@EqualsAndHashCode(callSuper = true)
public class ViewPointTagDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -50837473992469492L;


    /**
     * 观点id
     */
    @ApiModelProperty("观点id")
    private Integer pointId;

    /**
     * 标签id
     */
    @ApiModelProperty("标签id")
    private Integer tagId;
}

