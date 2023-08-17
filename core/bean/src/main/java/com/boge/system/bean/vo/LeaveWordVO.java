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
 * 留言表(LeaveWord)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:52
 */
@Data
@ApiModel("留言表")
@EqualsAndHashCode(callSuper = true)
public class LeaveWordVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = -24211363549901582L;


    /**
     * 称呼
     */
    @ApiModelProperty("称呼")
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 留言
     */
    @ApiModelProperty("留言")
    private String leaveWord;

    /**
     * 网址
     */
    @ApiModelProperty("网址")
    private String website;

    /**
     * 留言时间
     */
    @ApiModelProperty("留言时间")
    @JsonFormat(pattern = DateConstants.YY_MM_DD_HH_MM_SS)
    private Date time;
}

