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
 * 职位表(Position)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:52
 */
@Data
@ApiModel("职位表")
@MySort(fields = {"time"}, methods = {2})
@EqualsAndHashCode(callSuper = true)
public class PositionDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = -73160975468191657L;


    /**
     * 职位标题
     */
    @ApiModelProperty("职位标题")
    @NotBlank(message = "职位标题不能为空", groups = {Validator.Create.class})
    @MyQuery(like = true)
    private String title;

    /**
     * 职位职责
     */
    @ApiModelProperty("职位职责")
    @NotBlank(message = "职位职责不能为空", groups = {Validator.Create.class})
    @MyQuery(like = true)
    private String duty;

    /**
     * 职位要求
     */
    @ApiModelProperty("职位要求")
    @NotBlank(message = "职位要求不能为空", groups = {Validator.Create.class})
    @MyQuery(like = true)
    private String demand;
}

