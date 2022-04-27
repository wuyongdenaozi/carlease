package com.demo.carlease.exception.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户信息修改数据封装类
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/10
 */
@Data
public class UserInfoDTO {

    /**
     * 用户编号
     */
    @NotNull
    private Long id;

    /**
     * 用户昵称(显示名称)
     */
    private String nick;

    /**
     * 用户电话
     */
    @Length(min = 11, max = 13)
    private String phone;

    /**
     * 用户邮箱
     */
    @Email(message = "邮箱格式不正确")
    private String email;

}
