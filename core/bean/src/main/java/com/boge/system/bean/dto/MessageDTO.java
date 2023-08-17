package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import java.io.Serializable;

/**
 * 资讯表(Message)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:52
 */
@Data
@ApiModel("资讯表")
@EqualsAndHashCode(callSuper = true)
public class MessageDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -15038340256631047L;


    /**
     * 资讯标题
     */
    @ApiModelProperty("资讯标题")
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
    private Integer authorImage;

    /**
     * 摘要
     */
    @ApiModelProperty("摘要")
    private String digest;

    /**
     * 类型 1、建站知识库 2、外贸独立站知识库 3、营销型网站知识库 4、网站设计资讯 5、SEM 竞价资讯 6 、网站建设资讯
     */
    @ApiModelProperty("类型 1、建站知识库 2、外贸独立站知识库 3、营销型网站知识库 4、网站设计资讯 5、SEM 竞价资讯 6 、网站建设资讯")
    private Integer type;

    /**
     * 题图（文件id）
     */
    @ApiModelProperty("题图（文件id）")
    private Integer messageImage;

    /**
     * 正文
     */
    @ApiModelProperty("正文")
    private String mainBody;

    /**
     * 时间
     */
    @ApiModelProperty("时间")
    private Date time;
}

