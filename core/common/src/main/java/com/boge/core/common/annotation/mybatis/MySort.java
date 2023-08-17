package com.boge.core.common.annotation.mybatis;

import java.lang.annotation.*;

/**
 * 自定义查询排序字段
 * @Author boge
 * @Date 2022/10/14 10:49
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MySort {
    /**
     * 排序字段
     */
    String[] fields() default {};

    /**
     * 排序方式  0、丢弃 1、升序 2、降序
     */
    int[] methods() default {};
}
