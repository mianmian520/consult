package com.boge.core.common.enums;

/**
 * 响应编码枚举
 * @Author boge
 * @Date 2022/9/13 20:04
 */
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 系统内部错误，请联系管理员
     */
    ERROR(500, "系统内部错误，请联系管理员"),
    /**
     * 认证失败
     */
    UNAUTHORIZED(401, "用户认证失败"),
    /**
     * 拒绝请求
     */
    FORBIDDEN(403, "拒绝请求"),
    /**
     * 未找到该请求
     */
    NOT_FOUND(404, "未找到该请求");

    private final int code;

    private final String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
