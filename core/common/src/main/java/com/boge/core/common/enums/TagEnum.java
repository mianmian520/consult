package com.boge.core.common.enums;

/**
 * @Author boge
 * @Date 2023/8/17 12:45
 */
public enum TagEnum {
    /**
     * 服务标签
     */
    SERVER(1),
    /**
     * 行业标签
     */
    PROFESSION(2),
    /**
     * 观点标签
     */
    VIEWPOINT(3);

    private final int code;

    TagEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
