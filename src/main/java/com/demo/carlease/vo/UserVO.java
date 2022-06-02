package com.demo.carlease.vo;

import lombok.Data;

/**
 * <p>
 * 用户信息返回封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2021/12/19
 */
@Data
public class UserVO {

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 用户昵称(显示名称)
     */
    private String nick;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户身份证号
     */
    private String cd;
}
