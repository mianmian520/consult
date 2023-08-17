package com.boge.core.common.consts;

/**
 * http请求头常量
 * @Author boge
 * @Date 2022/10/14 16:22
 */
public class HttpHeaderConstants {

    /**
     * 请求头token
     */
    public final static String TOKEN = "Authentication";

    public static final String CONTENT_TYPE = "Content-Type";

    public static final String CONTENT_LENGTH= "Content-Length";

    public static final String CONTENT_DISPOSITION = "Content-Disposition";

    public static final String OCTET_STREAM = "application/octet-stream;charset=UTF-8";

    public static final String ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";

    public static final String EXPOSE_HEADERS= "Access-Control-Expose-Headers";
}
