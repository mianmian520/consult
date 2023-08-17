package com.boge.core.common.annotation.mybatis;

import java.lang.annotation.*;

/**
 * 重复判断注解
 * @Author boge
 * @Date 2022/9/13 20:36
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MyRepeated {

    /**
     * 字段提示信息
     */
    String value() default "";
}
