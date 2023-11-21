package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import com.boge.core.common.consts.DateConstants;
import com.boge.core.common.enums.CaseTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 案例表(Case)实体类
 *
 * @author boge
 * @since 2023-08-8 08:55:11
 */
@Data
@ApiModel("案例表")
@EqualsAndHashCode(callSuper = true)
public class CaseVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = -28483335881640153L;


    /**
     * 案例标题
     */
    @ApiModelProperty("案例标题")
    private String title;

    /**
     * 公司
     */
    @ApiModelProperty("公司")
    private String company;

    /**
     * 公司logo（文件id）
     */
    @ApiModelProperty("公司logo（文件id）")
    private Long logo;

    /**
     * 公司网址
     */
    @ApiModelProperty("公司网址")
    private String website;

    /**
     * 服务标签id
     */
    @ApiModelProperty("服务标签id")
    private Long serverTag;

    /**
     * 服务标签标题
     */
    @ApiModelProperty("服务标签标题")
    private String serverTagTitle;

    /**
     * 行业标签id
     */
    @ApiModelProperty("行业标签id")
    private Long professionTag;

    /**
     * 行业标签标题
     */
    @ApiModelProperty("行业标签标题")
    private String professionTagTitle;

    @ApiModelProperty("摘要")
    private String digest;

    @ApiModelProperty("推荐 0、不推荐 1、推荐")
    private Integer recommend;

    /**
     * 类型 1、网站建设 2、广告运营 3、小程序APP
     */
    @ApiModelProperty("类型 1、网站建设 2、广告运营 3、小程序APP")
    private Integer type;

    @ApiModelProperty("类型名称")
    public String getTypeName() {
        return CaseTypeEnum.findTitle(this.type);
    }

    /**
     * 案例正文
     */
    @ApiModelProperty("案例正文")
    private String mainBody;

    /**
     * 题图（文件id）
     */
    @ApiModelProperty("题图（文件id）")
    private Long caseImage;

    /**
     * 时间
     */
    @ApiModelProperty("时间")
    @JsonFormat(pattern = DateConstants.YY_MM_DD_HH_MM_SS)
    private Date time;

    @ApiModelProperty("公司logo URL")
    public String getLogoUrl() {
        return "/file/download/" + this.logo;
    }

    @ApiModelProperty("题图 URL")
    public String getCaseImageUrl() {
        return "/file/download/" + this.caseImage;
    }
}

