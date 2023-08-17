package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

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
     * 公司logo（文件id）
     */
    @ApiModelProperty("公司logo（文件id）")
    private Integer logo;

    /**
     * 公司网址
     */
    @ApiModelProperty("公司网址")
    private String website;

    /**
     * 服务标签
     */
    @ApiModelProperty("服务标签")
    private Integer serverTag;

    /**
     * 行业标签
     */
    @ApiModelProperty("行业标签")
    private Integer professionTag;

    /**
     * 类型 网站建设、广告运营、小程序APP
     */
    @ApiModelProperty("类型 网站建设、广告运营、小程序APP")
    private String type;

    /**
     * 案例正文
     */
    @ApiModelProperty("案例正文")
    private String mainBody;

    /**
     * 题图（文件id）
     */
    @ApiModelProperty("题图（文件id）")
    private Integer caseImage;

    /**
     * 时间
     */
    @ApiModelProperty("时间")
    private Date time;
}
