package com.boge.core.common.utils;

import cn.hutool.core.util.IdUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author boge
 * @Date 2022/9/14 23:38
 */
public class JwtUtil {

    private final static String SECRET_KEY = "boge0302";

    public static String generateToken(Long id, String userName) {
        Map<String, Object> payload = new HashMap<>(3);
        payload.put(JWTPayload.JWT_ID, IdUtil.simpleUUID());
        payload.put("id", id);
        payload.put("userName", userName);
        return JWTUtil.createToken(payload, SECRET_KEY.getBytes());
    }

    public static boolean verify(String token) {
        return JWTUtil.verify(token, SECRET_KEY.getBytes());
    }

    public static String parse(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        String uuid = (String) jwt.getPayload(JWT.JWT_ID);
        String userName = (String) jwt.getPayload("userName");
        return userName + ":" + uuid;
    }

    public static Long parseId(String token) {
        JWT jwt = JWTUtil.parseToken(token);
        Integer id = (Integer) jwt.getPayload("id");
        return Long.valueOf(id);
    }
}
