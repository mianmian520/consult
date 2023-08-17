package com.boge.core.common.enums;

/**
 * 资讯类型枚举
 * @Author boge
 * @Date 2023/8/17 16:22
 */
public enum MessageTypeEnum {
    /**
     * 建站知识库
     */
    STATION(1, "建站知识库"),
    /**
     * 外贸独立站知识库
     */
    FOREIGN_TRADE(2, "外贸独立站知识库"),
    /**
     * 营销型网站知识库
     */
    MARKETING(3, "营销型网站知识库"),
    /**
     * 网站设计资讯
     */
    DESIGN(4, "网站设计资讯"),
    /**
     * SEM 竞价资讯
     */
    SEM(5, "SEM 竞价资讯"),
    /**
     * 网站建设资讯
     */
    CONSTRUCT(6, "网站建设资讯");


    private final int code;

    private final String title;

    MessageTypeEnum(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public static String findTitle(int code) {
        for (MessageTypeEnum typeEnum : values()) {
            if (typeEnum.code == code) {
                return typeEnum.title;
            }
        }
        return "";
    }
}
