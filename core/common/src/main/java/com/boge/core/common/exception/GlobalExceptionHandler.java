package com.boge.core.common.exception;

import com.boge.core.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author boge
 * @Date 2022/9/14 18:45
 */
@Slf4j
@Order(0)
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public Result<String> customExceptionHandler(CustomException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.fail(e.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.fail(e.getMessage(), null);
    }

    @ExceptionHandler(BindException.class)
    public Result<String> bindExceptionHandler(BindException e) {
        String msg = e.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).reduce((x, y) -> String.format("%s; %s", x, y)).orElse("参数输入有误");
        return Result.fail(msg, null);
    }
}
