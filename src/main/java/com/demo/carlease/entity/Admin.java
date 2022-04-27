package com.demo.carlease.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Getter
@Setter
@TableName("admin")
public class Admin extends BaseEntity {

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


}
