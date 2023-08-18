package com.boge.system.bean.dto;

import com.boge.core.common.annotation.mybatis.MySort;
import com.boge.core.common.base.model.BaseDTO;
import com.boge.core.common.model.Validator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 简历表(CurriculumVitae)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:51
 */
@Data
@ApiModel("简历表")
@MySort(fields = {"time"}, methods = {2})
@EqualsAndHashCode(callSuper = true)
public class CurriculumVitaeDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = 525507429833497948L;

    /**
     * 职位id
     */
    @ApiModelProperty("职位id")
    private Long positionId;
    /**
     * 职位Title
     */
    @ApiModelProperty("职位Title")
    private String positionTitle;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @NotBlank(message = "姓名不能为空", groups = {Validator.Create.class})
    private String name;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    @NotBlank(message = "性别不能为空", groups = {Validator.Create.class})
    private String sex;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @NotBlank(message = "手机号不能为空", groups = {Validator.Create.class})
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    @NotBlank(message = "邮箱不能为空", groups = {Validator.Create.class})
    private String email;


    /**
     * 简历文件id
     */
    @ApiModelProperty("简历文件id")
    @NotNull(message = "简历文件不能为空", groups = {Validator.Create.class})
    private Long attachmentId;
}

