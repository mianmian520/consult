package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 预约表(Subscribe)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:53
 */
@Data
@ApiModel("预约表")
@EqualsAndHashCode(callSuper = true)
public class SubscribeDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -64601209779458700L;


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
}

