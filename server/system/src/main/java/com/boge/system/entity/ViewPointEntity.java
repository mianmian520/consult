package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 观点表(ViewPoint)实体类
 *
 * @author boge
 * @since 2023-08-17 10:00:20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_view_point")
public class ViewPointEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -14163354782667100L;
    /**
     * 观点标题
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
     * 观点人物
     */
    private String person;
    /**
     * 观点人物头像（文件id）
     */
    private Long personImage;
    /**
     * 类型 1、增长观点 2、项目日记 3、公司动态 4、设计观点
     */
    private Integer type;
    /**
     * 题图（文件id）
     */
    private Long viewImage;
    /**
     * 正文
     */
    private String mainBody;
    /**
     * 创建时间
     */
    private Date time;
    /**
     * 摘要
     */
    private String digest;

    /**
     * 推荐 0、不推荐 1、推荐
     */
    private Integer recommend;
}

