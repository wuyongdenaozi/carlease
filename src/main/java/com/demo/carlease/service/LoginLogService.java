package com.demo.carlease.service;

import com.demo.carlease.entity.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.carlease.vo.LoginLogVO;

import java.util.List;

/**
 * <p>
 * 管理员登录日志 服务类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
public interface LoginLogService extends IService<LoginLog> {

    /**
     * 获取所有登录日志方法
     * @return
     */
    List<LoginLogVO> getAll();

    /**
     * 添加登录日志方法
     */
    void addLoginLog(Long userId);
}
