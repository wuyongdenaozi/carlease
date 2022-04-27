package com.demo.carlease.exception.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 用户登录信息封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2021/12/19
 */
@Data
public class LoginDTO {

    /**
     * 登录用户名
     */
    @NotBlank(message = "必须输入用户名")
    private String username;

    /**
     * 登录密码
     */
    @NotBlank(message = "必须输入密码")
    private String password;

}
