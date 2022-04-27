package com.demo.carlease.exception;

/**
 * <p>
 * 自定义异常类公共父类
 * </p>
 *
 * @author 李嘉明
 * create time 2021/12/19
 */
public class BaseException extends RuntimeException {

    public BaseException() {}

    public BaseException(String message) {
        super(message);
    }
}
