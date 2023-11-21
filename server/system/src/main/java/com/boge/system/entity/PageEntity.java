package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 页面(Page)实体类
 *
 * @author boge
 * @since 2023-08-17 18:03:07
 */
@Data
@TableName("sys_page")
public class PageEntity implements Serializable {
    private static final long serialVersionUID = -52020447427943839L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 页面标题
     */
    @ApiModelProperty("页面标题")
    private String title;

    /**
     * 前端路由
     */
    @ApiModelProperty("前端路由")
    private String path;

}

