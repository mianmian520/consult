package com.boge.core.common.annotation.mybatis;

import java.lang.annotation.*;

/**
 * 分页查询条件注解
 * @Author boge
 * @Date 2022/9/13 20:36
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MyQuery {

    String value() default "";

    /**
     * 是否模糊查询
     */
    boolean like() default false;

    /**
     * 小于
     */
    boolean lt() default false;

    /**
     * 大于
     */
    boolean gt() default false;

    /**
     * 等于
     */
    boolean eq() default true;

    String field() default "";
}
