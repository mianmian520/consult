package com.boge.core.common.enums;

/**
 * 观点人物枚举
 * @Author boge
 * @Date 2023/8/17 16:22
 */
public enum ViewPointTypeEnum {
    /**
     * 网站建设
     */
    INCREASE(1, "增长观点"),
    /**
     * 项目日记
     */
    DIARY(2, "项目日记"),
    /**
     * 公司动态
     */
    DYNAMIC(3, "公司动态"),
    /**
     * 设计观点
     */
    DESIGN(4, "设计观点");


    private final int code;

    private final String title;

    ViewPointTypeEnum(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public static String findTitle(int code) {
        for (ViewPointTypeEnum typeEnum : values()) {
            if (typeEnum.code == code) {
                return typeEnum.title;
            }
        }
        return "";
    }
}
