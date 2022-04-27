package com.demo.carlease.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.carlease.entity.LoginLog;
import com.demo.carlease.repository.LoginLogRepository;
import com.demo.carlease.service.LoginLogService;
import com.demo.carlease.vo.LoginLogVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 管理员登录日志 服务实现类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogRepository, LoginLog> implements LoginLogService {

    private final LoginLogRepository loginLogRepository;

    public LoginLogServiceImpl(LoginLogRepository loginLogRepository) {
        this.loginLogRepository = loginLogRepository;
    }

    @Override
    public List<LoginLogVO> getAll() {
        return loginLogRepository.getAll();
    }

    @Override
    public void addLoginLog(Long userId) {
        LoginLog log = new LoginLog();
        log.setUserId(userId);
        log.setLoginDatetime(LocalDateTime.now());
        log.setCreateDatetime(LocalDateTime.now());
        this.save(log);
    }
}
