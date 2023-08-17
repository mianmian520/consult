package com.boge.core.common.base.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 基础VO类
 * @Author boge
 * @Date 2022/9/13 20:21
 */
@Data
public class BaseVO<T> implements Serializable {

    /**
     * 主键id
     */
    private T id;
}
