package com.demo.carlease.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.carlease.exception.dto.LoginDTO;
import com.demo.carlease.entity.Admin;
import com.demo.carlease.repository.AdminRepository;
import com.demo.carlease.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.carlease.service.LoginLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Service
@RequiredArgsConstructor
public class AdminServiceImpl extends ServiceImpl<AdminRepository, Admin> implements AdminService {

    private final LoginLogService loginLogService;

    @Override
    public Boolean login(LoginDTO validator) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Admin::getUsername, validator.getUsername())
                .eq(Admin::getPassword, validator.getPassword());
        Admin admin = getOne(wrapper);
        return Objects.nonNull(admin);
    }
}
