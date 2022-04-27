package com.demo.carlease.exception;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * <p>
 * validator 校验异常信息封装
 * </p>
 *
 * @author 李嘉明
 * create time 2021/12/19
 */
@Getter
public class ValidatorException extends BaseException {

    private List<ObjectError> messages;

    public ValidatorException(List<ObjectError> messages) {
        this.messages = messages;
    }

}
