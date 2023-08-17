package com.boge.core.common.exception;

/**
 * @Author boge
 * @Date 2022/9/14 8:16
 */
public class CustomException extends Exception {

    private final int code;

    public CustomException(String message) {
        super(message);
        this.code = 500;
    }

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }
}
