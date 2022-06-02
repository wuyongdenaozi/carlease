package com.demo.carlease.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 订单信息封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/27
 */
@Data
public class OrdersDTO {

    /**
     * 用户id
     */
    @NotNull
    private Long userId;

    /**
     * 汽车id
     */
    @NotNull
    private Long carId;

    /**
     * 租赁天数
     */
    private Integer date;

    /**
     * 租赁价格
     */
    private Double price;

    /**
     * 是否租赁完成
     */
    private Boolean flag;

}
