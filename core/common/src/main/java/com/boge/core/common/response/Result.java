package com.boge.core.common.response;

import com.boge.core.common.enums.ResultEnum;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 统一返回类
 * @Author boge
 * @Date 2022/9/13 20:00
 */
@Data
@Builder
@ToString
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 相应码
     */
    private int code;

    /**
     * 返回状态说明，success为false情况下表示失败原因
     */
    private String message;

    /**
     * 返回对象
     */
    private T data;

    /**
     * 响应时间戳
     */
    private Long timestamp;

    public static <T> Result<T> success() {
        return Result.success(null);
    }

    public static <T> Result<T> success(T data) {
        return Result.success(ResultEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return Result.success(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> Result<T> success(int code, String message, T data) {
        return Result.<T>builder().code(code).message(message).data(data).timestamp(System.currentTimeMillis()).build();
    }

    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    public static <T> Result<T> fail(T data) {
        return Result.fail(ResultEnum.ERROR.getMsg(), data);
    }

    public static <T> Result<T> fail(String message, T data) {
        return Result.fail(ResultEnum.ERROR.getCode(), message, data);
    }

    public static <T> Result<T> fail(int code, String message, T data) {
        return Result.<T>builder().code(code).message(message).data(data).timestamp(System.currentTimeMillis()).build();
    }

    public static <T> Result<T> unauthorized() {
        return Result.<T>builder().code(ResultEnum.UNAUTHORIZED.getCode()).message(ResultEnum.UNAUTHORIZED.getMsg()).timestamp(System.currentTimeMillis()).build();
    }

    public static <T> Result<T> unauthorized(String message) {
        return Result.<T>builder().code(ResultEnum.UNAUTHORIZED.getCode()).message(message).timestamp(System.currentTimeMillis()).build();
    }

    public static <T> Result<T> notFound() {
        return Result.<T>builder().code(ResultEnum.NOT_FOUND.getCode()).message(ResultEnum.NOT_FOUND.getMsg()).timestamp(System.currentTimeMillis()).build();
    }

    public static <T> Result<T> forbidden() {
        return Result.<T>builder().code(ResultEnum.FORBIDDEN.getCode()).message(ResultEnum.FORBIDDEN.getMsg()).timestamp(System.currentTimeMillis()).build();
    }
}
