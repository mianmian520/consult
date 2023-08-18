package com.boge.system.bean.dto;

import com.boge.core.common.annotation.mybatis.MyQuery;
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
 * 资讯表(Message)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:52
 */
@Data
@ApiModel("资讯表")
@MySort(fields = {"time"}, methods = {2})
@EqualsAndHashCode(callSuper = true)
public class MessageDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -15038340256631047L;

    /**
     * 资讯标题
     */
    @ApiModelProperty("资讯标题")
    @MyQuery(like = true)
    @NotBlank(message = "资讯标题不能为空", groups = {Validator.Create.class})
    private String title;

    /**
     * 作者
     */
    @ApiModelProperty("作者")
    @NotBlank(message = "作者标题不能为空", groups = {Validator.Create.class})
    private String author;

    /**
     * 作者头像（文件id）
     */
    @ApiModelProperty("作者头像（文件id）")
    @NotNull(message = "作者头像不能为空", groups = {Validator.Create.class})
    private Long authorImage;

    /**
     * 摘要
     */
    @ApiModelProperty("摘要")
    private String digest;

    /**
     * 类型 1、建站知识库 2、外贸独立站知识库 3、营销型网站知识库 4、网站设计资讯 5、SEM 竞价资讯 6 、网站建设资讯
     */
    @MyQuery
    @ApiModelProperty("类型 1、建站知识库 2、外贸独立站知识库 3、营销型网站知识库 4、网站设计资讯 5、SEM 竞价资讯 6 、网站建设资讯")
    private Integer type;

    /**
     * 题图（文件id）
     */
    @ApiModelProperty("题图（文件id）")
    @NotNull(message = "题图不能为空", groups = {Validator.Create.class})
    private Long messageImage;

    /**
     * 正文
     */
    @ApiModelProperty("正文")
    private String mainBody;

}

