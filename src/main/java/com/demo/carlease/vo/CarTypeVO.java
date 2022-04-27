package com.demo.carlease.vo;

import lombok.Data;

/**
 * <p>
 * 汽车类型信息返回封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2021/12/22
 */
@Data
public class CarTypeVO {

    /**
     * 汽车类型编号
     */
    private Long id;

    /**
     * 汽车类型名称
     */
    private String name;
}
