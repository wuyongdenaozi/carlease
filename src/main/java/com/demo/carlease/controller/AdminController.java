package com.demo.carlease.controller;


import com.demo.carlease.dto.LoginDTO;
import com.demo.carlease.exception.ValidatorException;
import com.demo.carlease.service.AdminService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 管理员登录方法
     *
     * @param validator 登录信息校验器
     * @param result 校验结果
     * @return 登录结果 true | false
     */
    @PostMapping("/login")
    public Boolean login(@RequestBody @Validated LoginDTO validator, BindingResult result) {
        if (result.getErrorCount() != 0) {
            throw new ValidatorException(result.getAllErrors());
        }
        return adminService.login(validator);
    }

}
