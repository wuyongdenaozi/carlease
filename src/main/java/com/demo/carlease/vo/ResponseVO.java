package com.demo.carlease.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 返回类型包装类
 *
 * @author 李嘉明
 * create time 2021/12/19
 */
@Data
@Builder
public class ResponseVO {

    private String status;

    private Object result;

    private List<String> errors;

}
