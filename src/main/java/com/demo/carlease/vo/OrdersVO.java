package com.demo.carlease.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 订单信息返回封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/29
 */
@Data
public class OrdersVO {

    /**
     * 订单编号
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 汽车id
     */
    private Long carId;

    /**
     * 汽车名称
     */
    private String carName;

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

    private LocalDateTime orderDatetime;

}
