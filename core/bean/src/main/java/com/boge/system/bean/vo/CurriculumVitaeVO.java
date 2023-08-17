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
 * 简历表(CurriculumVitae)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:51
 */
@Data
@ApiModel("简历表")
@EqualsAndHashCode(callSuper = true)
public class CurriculumVitaeVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = -84558146605596590L;


    /**
     * 职位id
     */
    @ApiModelProperty("职位id")
    private Long positionId;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 时间
     */
    @ApiModelProperty("时间")
    @JsonFormat(pattern = DateConstants.YY_MM_DD_HH_MM_SS)
    private Date time;
}

