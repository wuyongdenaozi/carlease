package com.demo.carlease.vo;

import lombok.Data;

/**
 * <p>
 * 汽车信息返回封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2021/12/19
 */
@Data
public class CarVO {

    /**
     * 汽车编号
     */
    private Long id;

    /**
     * 汽车名称
     */
    private String name;
    /**
     * 所在地点
     */
    private String address;

    /**
     * 租赁价格
     */
    private Double price;

    /**
     * 所属用户id
     */
    private Long userId;

    /**
     * 所属用户名称
     */
    private String userNick;

    /**
     * 所属用户电话
     */
    private String userPhone;

    /**
     * 所属类型id
     */
    private Long typeId;

    /**
     * 所属类型名称
     */
    private String typeName;

    /**
     * 是否租赁中
     */
    private Boolean flag;

    /**
     * 租赁次数
     */
    private Integer number;

    /**
     * 汽车描述
     */
    private String describes;

    /**
     * 封面图
     */
    private String img;

}
