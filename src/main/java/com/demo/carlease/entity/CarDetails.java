package com.demo.carlease.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

/**
 * <p>
 * 汽车详情表
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/11
 */
@Getter
@Setter
@TableName("car_details")
public class CarDetails extends BaseEntity {

    /**
     * 所属汽车 id
     */
    @TableField("car_id")
    private Long carId;

    /**
     * 汽车描述
     */
    @TableField(value = "describes", jdbcType = JdbcType.VARCHAR)
    private String describes;

    /**
     * 封面图
     */
    @TableField(value = "img", jdbcType = JdbcType.VARCHAR)
    private String img;
}
