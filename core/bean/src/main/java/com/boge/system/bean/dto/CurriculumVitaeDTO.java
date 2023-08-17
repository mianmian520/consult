package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import java.io.Serializable;

/**
 * 简历表(CurriculumVitae)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:51
 */
@Data
@ApiModel("简历表")
@EqualsAndHashCode(callSuper = true)
public class CurriculumVitaeDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = 525507429833497948L;


    /**
     * 职位id
     */
    @ApiModelProperty("职位id")
    private Integer positionId;

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
    private Date time;
}

