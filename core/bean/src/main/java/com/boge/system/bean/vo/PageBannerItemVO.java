package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 页面栏目配置表(PageBannerItem)实体类
 *
 * @author boge
 * @since 2023-08-17 18:00:50
 */
@Data
@ApiModel("页面栏目配置表")
@EqualsAndHashCode(callSuper = true)
public class    PageBannerItemVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = -50713940711140608L;


    /**
     * 栏目id
     */
    @ApiModelProperty("栏目id")
    private Long bannerId;

    /**
     * 内容名称
     */
    @ApiModelProperty("内容名称")
    private String contentTitle;

    /**
     * 内容描述
     */
    @ApiModelProperty("内容描述")
    private String contentDesc;

    /**
     * 初始效果图
     */
    @ApiModelProperty("初始效果图")
    private Long initImage;

    /**
     * 焦点效果图
     */
    @ApiModelProperty("焦点效果图")
    private Long focusImage;

    /**
     *
     * 连接类型 xx两位数 十位(1、案例 2、观点 3、资讯 4、职位) 个位(具体类型)
     */
    @ApiModelProperty("连接类型 xx两位数 十位(1、案例 2、观点 3、资讯 4、职位 5、首页) 个位(具体类型)")
    private Integer connectType;

    /**
     * 连接内容id 根据类型来判断数据来源
     */
    @ApiModelProperty("连接内容id 根据类型来判断数据来源")
    private Long connectId;

    @ApiModelProperty("连接内容标题")
    private String connectTitle;

    @ApiModelProperty("连接内容路由")
    private String connectPath;

    /**
     * 顺序
     */
    @ApiModelProperty("顺序")
    private Integer sort;

    @ApiModelProperty("预留字段1")
    private String reserve1;

    @ApiModelProperty("预留字段2")
    private String reserve2;


    @ApiModelProperty("初始效果图 URL")
    public String getInitImageUrl() {
        return "/file/download/" + this.initImage;
    }

    @ApiModelProperty("焦点效果图 URL")
    public String getFocusImageUrl() {
        return "/file/download/" + this.focusImage;
    }
}

