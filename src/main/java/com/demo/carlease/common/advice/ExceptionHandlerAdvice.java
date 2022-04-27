package com.demo.carlease.common.advice;

import com.demo.carlease.exception.UserException;
import com.demo.carlease.exception.ValidatorException;
import com.demo.carlease.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 通过 Advice 统一异常返回结构
 *
 * @author 李嘉明
 * create time 2021/12/19
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseBody
    @ResponseStatus
    @ExceptionHandler(Exception.class)
    public ResponseVO handleException(Exception e) {
        if (e instanceof ValidatorException) {
            // 参数校验异常, 捕获所有异常信息
            List<String> errors = new ArrayList<>();
            ((ValidatorException) e).getMessages().forEach(error -> {
                // 异常日志打印
                log.warn(error.getDefaultMessage(), error);
                // 异常信息封装
                errors.add(error.getDefaultMessage());
            });
            // 返回自定义封装结果
            return ResponseVO.builder().status("VALID_ERROR").errors(errors).build();
        } else if (e instanceof UserException) {
            // 异常日志打印
            log.warn(e.getMessage(), e);
            // 异常信息封装
            List<String> errors = new ArrayList<>();
            errors.add(e.getMessage());
            // 返回自定义封装结果
            return ResponseVO.builder().status("USER_ERROR").errors(errors).build();
        } else {
            // 异常日志打印
            log.error(e.getMessage(), e);
            // 返回自定义封装结果
            return ResponseVO.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .errors(Collections.singletonList(e.getMessage())).build();
        }
    }

}
