package com.demo.carlease.controller;


import com.demo.carlease.exception.dto.LoginDTO;
import com.demo.carlease.exception.dto.RegisterDTO;
import com.demo.carlease.exception.dto.UserInfoDTO;
import com.demo.carlease.exception.ValidatorException;
import com.demo.carlease.service.UserService;
import com.demo.carlease.vo.UserVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录方法
     *
     * @param validator 登录信息校验器
     * @param result 校验结果
     * @return 登录用户信息 | null
     */
    @PostMapping("/login")
    public UserVO login(@RequestBody @Validated LoginDTO validator, BindingResult result) {
        if (result.getErrorCount() != 0) {
            throw new ValidatorException(result.getAllErrors());
        }
        return userService.login(validator);
    }

    /**
     * 用户注册方法
     *
     * @param validator 注册信息校验器
     * @param result 校验结果
     * @return 注册结果 true | false
     */
    @PostMapping("/register")
    public Boolean register(@RequestBody @Validated RegisterDTO validator, BindingResult result) {
        if (result.getErrorCount() != 0) {
            throw new ValidatorException(result.getAllErrors());
        }
        return userService.register(validator);
    }

    /**
     * 用户信息修改方法
     *
     * @param validator 修改信息校验器
     * @param result 校验结果
     * @return 修改后信息
     */
    @PutMapping
    public UserVO changeInfo(@RequestBody @Validated UserInfoDTO validator, BindingResult result) {
        if (result.getErrorCount() != 0) {
            throw new ValidatorException(result.getAllErrors());
        }
        return  userService.update(validator);
    }

    /**
     * 获取所有用户登录信息
     *
     * @return 登录信息集合
     */
    @GetMapping
    public List<UserVO> getAllUser() {
        return userService.findAll();
    }

}
