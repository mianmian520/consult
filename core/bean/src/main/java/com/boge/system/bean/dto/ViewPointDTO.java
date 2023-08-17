package com.boge.system.bean.dto;

import com.boge.core.common.base.model.BaseDTO;
import com.boge.core.common.model.Validator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 观点表(ViewPoint)实体类
 *
 * @author boge
 * @since 2023-08-17 09:59:53
 */
@Data
@ApiModel("观点表")
@EqualsAndHashCode(callSuper = true)
public class ViewPointDTO extends BaseDTO<Long> implements Serializable {

    private static final long serialVersionUID = 849759314857009462L;

    /**
     * 观点标题
     */
    @ApiModelProperty("观点标题")
    @NotBlank(message = "观点标题不能为空", groups = {Validator.Create.class})
    private String title;

    /**
     * 作者
     */
    @ApiModelProperty("作者")
    @NotBlank(message = "作者不能为空", groups = {Validator.Create.class})
    private String author;

    /**
     * 作者头像（文件id）
     */
    @ApiModelProperty("作者头像（文件id）")
    @NotNull(message = "作者头像不能为空", groups = {Validator.Create.class})
    private Long authorImage;

    /**
     * 观点人物
     */
    @ApiModelProperty("观点人物")
    @NotBlank(message = "观点人物不能为空", groups = {Validator.Create.class})
    private String person;

    /**
     * 观点人物头像（文件id）
     */
    @ApiModelProperty("观点人物头像（文件id）")
    @NotNull(message = "观点人物头像不能为空", groups = {Validator.Create.class})
    private Long personImage;

    /**
     * 类型 1、增长观点 2、项目日记 3、公司动态 4、设计观点
     */
    @ApiModelProperty("类型 1、增长观点 2、项目日记 3、公司动态 4、设计观点")
    @NotNull(message = "类型不能为空", groups = {Validator.Create.class})
    private Integer type;

    /**
     * 题图（文件id）
     */
    @ApiModelProperty("题图（文件id）")
    @NotNull(message = "题图不能为空", groups = {Validator.Create.class})
    private Long viewImage;

    /**
     * 正文
     */
    @ApiModelProperty("正文")
    private String mainBody;

    @ApiModelProperty("观点人物标签id集合")
    @NotEmpty(message = "标签id集合不能为空", groups = {Validator.Create.class, Validator.Modify.class})
    private List<Long> tagIds;

}

