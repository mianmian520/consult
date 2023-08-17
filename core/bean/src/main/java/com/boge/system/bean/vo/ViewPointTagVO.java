package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class ViewPointTagVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = 675151622000694812L;


    /**
     * 观点id
     */
    @ApiModelProperty("观点id")
    private Long pointId;

    /**
     * 标签id
     */
    @ApiModelProperty("标签id")
    private Long tagId;
}

