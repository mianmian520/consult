package com.boge.core.common.base.model;

import com.boge.core.common.model.Validator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 基础DTO类
 * @Author boge
 * @Date 2022/9/13 20:21
 */
@Data
public class BaseDTO<T> implements Serializable {

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "主键不能为空", groups = {Validator.Modify.class})
    private T id;

    /**
     * 查询页码 默认为1
     */
    @ApiModelProperty("当前页，默认为1")
    private Integer currPage;

    /**
     * 每页大小 默认10
     */
    @ApiModelProperty("页大小,默认10")
    private Integer pageSize;

    public Integer getCurrPage() {
        return currPage == null ? 1 : currPage;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }
}
