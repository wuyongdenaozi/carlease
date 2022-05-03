package com.demo.carlease.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 汽车信息表
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Getter
@Setter
@TableName("car")
public class Car extends BaseEntity {

    /**
     * 汽车名称
     */
    @TableField("name")
    private String name;

    /**
     * 所在地点
     */
    @TableField("address")
    private String address;

    /**
     * 租赁价格
     */
    @TableField("price")
    private Double price;

    /**
     * 所属用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 所属类型id
     */
    @TableField("type_id")
    private Long typeId;

    /**
     * 是否租赁中
     */
    @TableField("flag")
    private Integer flag;

    /**
     * 租赁次数
     */
    @TableField("number")
    private Integer number;

}
