package com.boge.core.common.base.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础Entity类
 * @Author boge
 * @Date 2022/9/13 20:21
 */
@Data
public class BaseEntity<T> implements Serializable {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private T id;
}
