package com.boge.core.common.base.model;

import com.baomidou.mybatisplus.annotation.*;
import com.boge.core.common.consts.DateConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
