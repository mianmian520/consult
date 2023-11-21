package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 资讯表(Message)实体类
 *
 * @author boge
 * @since 2023-08-17 10:00:18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_message")
public class MessageEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -76623295068471439L;
    /**
     * 资讯标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 作者头像（文件id）
     */
    private Long authorImage;
    /**
     * 摘要
     */
    private String digest;
    /**
     * 类型 1、建站知识库 2、外贸独立站知识库 3、营销型网站知识库 4、网站设计资讯 5、SEM 竞价资讯 6 、网站建设资讯
     */
    private Integer type;

    /**
     * 推荐 0、不推荐 1、推荐
     */
    private Integer recommend;
    /**
     * 题图（文件id）
     */
    private Long messageImage;
    /**
     * 正文
     */
    private String mainBody;
    /**
     * 时间
     */
    private Date time;
}

