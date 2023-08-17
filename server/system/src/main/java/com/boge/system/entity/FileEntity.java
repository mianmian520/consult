package com.boge.system.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.boge.core.common.consts.DateConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 文件表(File)表实体类
 *
 * @author boge
 * @since 2023-08-8 08:36:16
 */
@Data
@TableName("sys_file")
public class FileEntity implements Serializable{

    private static final long serialVersionUID = -1L;

    /**
     * 文件id
     */
    @ApiModelProperty("文件id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 文件名称
     */
    @ApiModelProperty("文件名称")
    private String fileName;

    /**
     * 原名称
     */
    @ApiModelProperty("原名称")
    private String originName;

    /**
     * 文件路径
     */
    @ApiModelProperty("文件路径")
    private String filePath;

    /**
     * 时间
     */
    @ApiModelProperty("时间")
    @JsonFormat(pattern = DateConstants.YY_MM_DD_HH_MM_SS)
    private Date time;

}

