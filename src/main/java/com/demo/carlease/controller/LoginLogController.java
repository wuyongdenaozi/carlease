package com.demo.carlease.controller;


import com.demo.carlease.service.LoginLogService;
import com.demo.carlease.vo.LoginLogVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 管理员登录日志 前端控制器
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@RestController
@RequestMapping("/login-log")
public class LoginLogController {

    private final LoginLogService loginLogService;

    public LoginLogController(LoginLogService loginLogService) {
        this.loginLogService = loginLogService;
    }


    /**
     * 获取所有用户登录日志
     * @return
     */
    @GetMapping
    public List<LoginLogVO> getLogs() {
        return loginLogService.getAll();
    }

}
