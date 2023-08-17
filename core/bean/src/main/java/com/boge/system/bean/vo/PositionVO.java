package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import com.boge.core.common.consts.DateConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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

    /**
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    @JsonFormat(pattern = DateConstants.YY_MM_DD_HH_MM_SS)
    private Date time;
}

