package com.demo.carlease.service;

import com.demo.carlease.dto.LoginDTO;
import com.demo.carlease.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
public interface AdminService extends IService<Admin> {

    /**
     * 管理员登录方法
     *
     * @param validator 管理员登录数据校验器
     * @return 登录结果 true | false
     */
    Boolean login(LoginDTO validator);

}
