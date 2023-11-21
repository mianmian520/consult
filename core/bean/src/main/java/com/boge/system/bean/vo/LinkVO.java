package com.boge.system.bean.vo;

import com.boge.core.common.base.model.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 友链管理(Link)实体类
 *
 * @author boge
 * @since 2023-09-20 14:48:55
 */
@Data
@ApiModel("友链管理")
@EqualsAndHashCode(callSuper = true)
public class LinkVO extends BaseVO<Long> implements Serializable {

    private static final long serialVersionUID = 122964998242629545L;


    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 地址
     */
    @ApiModelProperty("地址")
    private String url;
}

