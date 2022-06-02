package com.demo.carlease.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 用户注册信息封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2021/12/20
 */
@Data
public class RegisterDTO {

    /**
     * 用户名(登录帐号)
     */
    @NotBlank(message = "必须输入用户名")
    private String username;

    /**
     * 登录密码
     */
    @NotBlank(message = "必须输入密码")
    private String password;

    /**
     * 用户昵称(显示名称)
     */
    @NotBlank(message = "必须输入用户昵称")
    private String nick;

    /**
     * 用户电话
     */
    @NotBlank(message = "必须输入用户电话")
    @Length(min = 11, max = 13)
    private String phone;

    /**
     * 用户邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 用户身份证号
     */
    @Length(min = 18, max = 18)
    private String cd;
}
