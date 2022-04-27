package com.demo.carlease.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 管理员登录日志
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Getter
@Setter
@TableName("login_log")
public class LoginLog extends BaseEntity {

    /**
     * 管理员id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 登录时间
     */
    @TableField("login_datetime")
    private LocalDateTime loginDatetime;


}
