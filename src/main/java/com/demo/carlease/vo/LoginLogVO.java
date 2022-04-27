package com.demo.carlease.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 登录日志信息放回封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/29
 */
@Data
public class LoginLogVO {

    /**
     * 日志 id
     */
    private Long id;

    /**
     * 登录用户名称
     */
    private String username;

    /**
     * 登录用户昵称
     */
    private String userNick;

    /**
     * 登录时间
     */
    private LocalDateTime loginDatetime;

}
