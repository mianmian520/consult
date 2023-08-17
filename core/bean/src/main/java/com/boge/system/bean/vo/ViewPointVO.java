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
 * 观点表(ViewPoint)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:54
 */
@Data
@ApiModel("观点表")
@EqualsAndHashCode(callSuper = true)
public class ViewPointVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = 275098911634753251L;


    /**
     * 观点标题
     */
    @ApiModelProperty("观点标题")
    private String title;

    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String author;

    /**
     * 作者头像（文件id）
     */
    @ApiModelProperty("作者头像（文件id）")
    private Long authorImage;

    /**
     * 观点人物
     */
    @ApiModelProperty("观点人物")
    private String person;

    /**
     * 观点人物头像（文件id）
     */
    @ApiModelProperty("观点人物头像（文件id）")
    private Long personImage;

    /**
     * 类型 1、增长观点 2、项目日记 3、公司动态 4、设计观点
     */
    @ApiModelProperty("类型 1、增长观点 2、项目日记 3、公司动态 4、设计观点")
    private Integer type;

    /**
     * 题图（文件id）
     */
    @ApiModelProperty("题图（文件id）")
    private Long viewImage;

    /**
     * 正文
     */
    @ApiModelProperty("正文")
    private String mainBody;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = DateConstants.YY_MM_DD_HH_MM_SS)
    private Date time;
}

