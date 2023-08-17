package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 留言表(LeaveWord)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:51
 */
@Data
@ApiModel("留言表")
@EqualsAndHashCode(callSuper = true)
public class LeaveWordDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = 432460749624682200L;


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

}

