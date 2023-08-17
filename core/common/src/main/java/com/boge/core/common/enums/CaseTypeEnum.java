package com.boge.core.common.enums;

/**
 * 案例枚举
 * @Author boge
 * @Date 2023/8/17 16:22
 */
public enum CaseTypeEnum {
    /**
     * 网站建设
     */
    WEBSITE(1, "网站建设"),
    /**
     * 广告运营
     */
    ADVERTISING(2, "广告运营"),
    /**
     * 小程序APP
     */
    APP(3, "小程序APP");


    private final int code;

    private final String title;

    CaseTypeEnum(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public static String findTitle(int code) {
        for (CaseTypeEnum typeEnum : values()) {
            if (typeEnum.code == code) {
                return typeEnum.title;
            }
        }
        return "";
    }
}
