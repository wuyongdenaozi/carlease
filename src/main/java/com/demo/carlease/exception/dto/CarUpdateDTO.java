package com.demo.carlease.exception.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 汽车信息修改数据
 *
 * @author 李嘉明
 * create time 2022/1/12
 */
@Data
public class CarUpdateDTO {

    /**
     * 汽车 id
     */
    @NotNull(message = "必须传入汽车编号")
    private Long id;

    /**
     * 汽车所在地
     */
    private String address;

    /**
     * 汽车出租价格
     */
    private Double price;

    /**
     * 汽车描述信息
     */
    private String describes;

}
