package com.demo.carlease.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 汽车类型表
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Getter
@Setter
@TableName("car_type")
public class CarType extends BaseEntity {

    /**
     * 汽车类型名称
     */
    @TableField("name")
    private String name;

}
