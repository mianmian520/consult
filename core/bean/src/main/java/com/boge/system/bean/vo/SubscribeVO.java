package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import com.boge.core.common.consts.DateConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约表(Subscribe)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:53
 */
@Data
@ApiModel("预约表")
@EqualsAndHashCode(callSuper = true)
public class SubscribeVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = -32061867949720822L;


    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 公司
     */
    @ApiModelProperty("公司")
    private String company;

    /**
     * 服务
     */
    @ApiModelProperty("服务")
    private String server;

    /**
     * 预算
     */
    @ApiModelProperty("预算")
    private String budget;

    /**
     * 联系
     */
    @ApiModelProperty("联系")
    private String telephone;

    /**
     * 邮件
     */
    @ApiModelProperty("邮件")
    private String email;

    /**
     * 预约时间
     */
    @ApiModelProperty("预约时间")
    @JsonFormat(pattern = DateConstants.YY_MM_DD_HH_MM_SS)
    private Date time;
}

