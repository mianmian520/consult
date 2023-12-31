package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import com.boge.core.common.consts.DateConstants;
import com.boge.core.common.enums.ViewPointTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
     * 摘要
     */
    @ApiModelProperty("摘要")
    private String digest;

    @ApiModelProperty("推荐 0、不推荐 1、推荐")
    private Integer recommend;

    /**
     * 类型 1、增长观点 2、项目日记 3、公司动态 4、设计观点
     */
    @ApiModelProperty("类型 1、增长观点 2、项目日记 3、公司动态 4、设计观点")
    private Integer type;

    @ApiModelProperty("类型名称")
    public String getTypeName() {
        return ViewPointTypeEnum.findTitle(this.type);
    }

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

    @ApiModelProperty("观点人物标签集合")
    private List<ViewPointTagVO> tags;

    @ApiModelProperty("作者头像 URL")
    public String getAuthorImageUrl() {
        return "/file/download/" + this.authorImage;
    }

    @ApiModelProperty("观点任务头像 URL")
    public String getPersonImageUrl() {
        return "/file/download/" + this.personImage;
    }

    @ApiModelProperty("题图 URL")
    public String getViewImageUrl() {
        return "/file/download/" + this.viewImage;
    }

    public String getTagTitles() {
        if (tags != null && !tags.isEmpty()) {
            return tags.stream().map(ViewPointTagVO::getTagTitle).collect(Collectors.joining(","));
        }
        return "";
    }
}

