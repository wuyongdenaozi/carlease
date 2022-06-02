package com.demo.carlease.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 汽车类型封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/8
 */
@Data
public class CarTypeDTO {

    /**
     * 新增汽车类型名
     */
    @NotBlank(message = "必须输入汽车类型")
    private String name;

}
