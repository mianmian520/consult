package com.boge.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boge.core.common.base.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 观点-标签表(ViewPointTag)实体类
 *
 * @author boge
 * @since 2023-08-17 11:08:01
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_view_point_tag")
public class ViewPointTagEntity extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = -17315983358092511L;
    /**
     * 观点id
     */
    private Long pointId;
    /**
     * 标签id
     */
    private Long tagId;

    public ViewPointTagEntity(Long pointId, Long tagId) {
        this.pointId = pointId;
        this.tagId = tagId;
    }
}

