package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import com.boge.core.common.consts.DateConstants;
import com.boge.core.common.enums.MessageTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 资讯表(Message)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:52
 */
@Data
@ApiModel("资讯表")
@EqualsAndHashCode(callSuper = true)
public class MessageVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = 395880240298266176L;


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
    private Long authorImage;

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

    @ApiModelProperty("类型名称")
    public String getTypeName() {
        return MessageTypeEnum.findTitle(this.type);
    }

    @ApiModelProperty("推荐 0、不推荐 1、推荐")
    private Integer recommend;

    /**
     * 题图（文件id）
     */
    @ApiModelProperty("题图（文件id）")
    private Long messageImage;

    /**
     * 正文
     */
    @ApiModelProperty("正文")
    private String mainBody;

    /**
     * 时间
     */
    @ApiModelProperty("时间")
    @JsonFormat(pattern = DateConstants.YY_MM_DD_HH_MM_SS)
    private Date time;


    @ApiModelProperty("作者头像 URL")
    public String getAuthorImageUrl() {
        return "/file/download/" + this.authorImage;
    }


    @ApiModelProperty("题图 URL")
    public String getMessageImageUrl() {
        return "/file/download/" + this.messageImage;
    }
}

