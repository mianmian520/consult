package com.boge.system.bean.dto;

import com.boge.core.common.annotation.mybatis.MyQuery;
import com.boge.core.common.annotation.mybatis.MySort;
import com.boge.core.common.base.model.BaseDTO;
import com.boge.core.common.model.Validator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 留言表(LeaveWord)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:51
 */
@Data
@ApiModel("留言表")
@MySort(fields = {"time"}, methods = {2})
@EqualsAndHashCode(callSuper = true)
public class LeaveWordDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = 432460749624682200L;


    /**
     * 称呼
     */
    @ApiModelProperty("称呼")
    @NotBlank(message = "称呼不能为空", groups = {Validator.Create.class})
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @NotBlank(message = "手机号不能为空", groups = {Validator.Create.class})
    private String phone;

    /**
     * 留言
     */
    @ApiModelProperty("留言")
    @MyQuery(like = true)
    private String leaveWord;

    /**
     * 网址
     */
    @ApiModelProperty("网址")
    private String website;

}

