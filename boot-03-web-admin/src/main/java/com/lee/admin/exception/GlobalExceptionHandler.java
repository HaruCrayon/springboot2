package com.lee.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author LiJing
 * @version 1.0
 * <p>
 * 处理整个 web controller的异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handleArithException(Exception e) {
        log.error("异常是：{}", e);

        return "login";
    }
}
