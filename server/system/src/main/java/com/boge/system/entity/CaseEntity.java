package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 案例表(Case)实体类
 *
 * @author boge
 * @since 2023-08-8 08:35:28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_case")
public class CaseEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = 956718621941887157L;
    /**
     * 案例标题
     */
    private String title;
    /**
     * 公司logo（文件id）
     */
    private Long logo;
    /**
     * 公司网址
     */
    private String website;
    /**
     * 服务标签
     */
    private Long serverTag;
    /**
     * 行业标签
     */
    private Long professionTag;
    /**
     * 类型 1、网站建设 2、广告运营 3、小程序APP
     */
    private Integer type;
    /**
     * 案例正文
     */
    private String mainBody;
    /**
     * 题图（文件id）
     */
    private Long caseImage;
    /**
     * 时间
     */
    private Date time;
}

