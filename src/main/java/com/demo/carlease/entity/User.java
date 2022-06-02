package com.demo.carlease.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Getter
@Setter
@TableName("user")
public class User extends BaseEntity {

    /**
     * 用户名(登录帐号)
     */
    @TableField("username")
    private String username;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户昵称(显示名称)
     */
    @TableField("nick")
    private String nick;

    /**
     * 用户电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 用户身份证号
     */
    @TableField("cd")
    private String cd;
}
