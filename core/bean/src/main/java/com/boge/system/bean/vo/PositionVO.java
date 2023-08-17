package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 职位表(Position)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:53
 */
@Data
@ApiModel("职位表")
@EqualsAndHashCode(callSuper = true)
public class PositionVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = -99909126282344295L;


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

