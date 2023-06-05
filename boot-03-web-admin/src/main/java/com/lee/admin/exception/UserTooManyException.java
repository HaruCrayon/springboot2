package com.lee.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author LiJing
 * @version 1.0
 * <p>
 * 自定义异常
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户数量太多")
public class UserTooManyException extends RuntimeException {

    public UserTooManyException() {
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
