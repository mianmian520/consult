package com.boge.core.common.utils;

import cn.hutool.crypto.SecureUtil;

import java.util.Random;

/**
 * 密码工具类
 * @Author boge
 * @Date 2022/9/14 13:09
 */
public class PasswordUtil {

    private static final Integer NUM = 16;

    private static final String SALT = "consult";

    /**
     * 生成随机盐
     */
    public static String createRandomSalt() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,?:@#$%&!<>";
        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i< NUM ; i++) {
            int nextInt = random.nextInt(str.length());
            sb.append(str.charAt(nextInt));
        }
        return sb.toString();
    }

    /**
     * 加密
     * @param text 密码
     * @param salt 盐值
     * @return 密文
     */
    public static String encrypt(String text, String salt) {
        return SecureUtil.md5().setSalt(salt.getBytes()).digestHex(text);
    }

    /**
     * 加密
     * @param text 密码
     * @return 密文
     */
    public static String encrypt(String text) {
        return SecureUtil.md5().setSalt(SALT.getBytes()).digestHex(text);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("123456"));
    }
}
