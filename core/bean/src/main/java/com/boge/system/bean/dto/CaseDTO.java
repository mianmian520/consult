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
 * 案例表(Case)实体类
 *
 * @author boge
 * @since 2023-08-8 08:55:10
 */
@Data
@ApiModel("案例表")
@MySort(fields = {"time"}, methods = {2})
@EqualsAndHashCode(callSuper = true)
public class CaseDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -76619439444431603L;

    /**
     * 案例标题
     */
    @ApiModelProperty("案例标题 查询可用")
    @NotBlank(message = "案例标题不能为空", groups = {Validator.Create.class})
    private String title;

    /**
     * 公司logo（文件id）
     */
    @ApiModelProperty("公司logo（文件id）")
    @NotNull(message = "公司logo不能为空", groups = {Validator.Create.class})
    private Long logo;

    /**
     * 公司网址
     */
    @ApiModelProperty("公司网址")
    @NotBlank(message = "公司网址不能为空", groups = {Validator.Create.class})
    private String website;

    /**
     * 服务标签
     */
    @ApiModelProperty("服务标签")
    @NotNull(message = "服务标签不能为空", groups = {Validator.Create.class})
    private Long serverTag;

    /**
     * 行业标签
     */
    @ApiModelProperty("行业标签")
    @NotNull(message = "行业标签不能为空", groups = {Validator.Create.class})
    private Long professionTag;

    /**
     * 类型 1、网站建设 2、广告运营 3、小程序APP
     */
    @ApiModelProperty("类型 1、网站建设 2、广告运营 3、小程序APP 查询可用")
    @NotNull(message = "类型不能为空", groups = {Validator.Create.class})
    private Integer type;

    /**
     * 案例正文
     */
    @ApiModelProperty("案例正文")
    @NotBlank(message = "案例正文不能为空", groups = {Validator.Create.class})
    private String mainBody;

    /**
     * 题图（文件id）
     */
    @ApiModelProperty("题图（文件id）")
    @NotNull(message = "题图不能为空", groups = {Validator.Create.class})
    private Long caseImage;
}

