package com.boge.system.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author boge
 * @Date 2023/9/25 9:14
 */
@Data
@ApiModel("上下篇")
public class NextAndPrev implements Serializable {

    @ApiModelProperty("下一篇id")
    private Long nextId;

    @ApiModelProperty("下一篇标题")
    private String nextTitle;

    @ApiModelProperty("上一篇id")
    private Long prevId;

    @ApiModelProperty("上一篇标题")
    private String pervTitle;
}
