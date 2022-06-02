package com.demo.carlease.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 汽车数据信息
 *
 * @author 李嘉明
 * create time 2022/1/11
 */
@Data
public class CarDTO {

    /**
     * 汽车名称
     */
    @NotBlank(message = "必须传入汽车名称")
    private String name;

    /**
     * 汽车所在地
     */
    @NotBlank(message = "必须传入汽车所在地")
    private String address;

    /**
     * 汽车租金
     */
    private Double price;

    /**
     * 汽车描述
     */
    private String describes;

    /**
     * 汽车类型 id
     */
    private Long typeId;

    /**
     * 汽车所有人 id
     */
    private Long userId;

    /**
     * 汽车封面图路径
     */
    private String img;

}
