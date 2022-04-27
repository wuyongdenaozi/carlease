package com.demo.carlease.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 租赁订单表
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Getter
@Setter
@TableName("orders")
public class Orders extends BaseEntity {

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 汽车id
     */
    @TableField("car_id")
    private Long carId;

    /**
     * 租赁天数
     */
    @TableField("date")
    private Integer date;

    /**
     * 租赁价格
     */
    @TableField("price")
    private Double price;

    /**
     * 是否租赁完成
     */
    @TableField("flag")
    private Boolean flag;

}
