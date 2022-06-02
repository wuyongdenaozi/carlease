package com.demo.carlease.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.carlease.dto.LoginDTO;
import com.demo.carlease.dto.RegisterDTO;
import com.demo.carlease.dto.UserInfoDTO;
import com.demo.carlease.entity.User;
import com.demo.carlease.exception.UserException;
import com.demo.carlease.repository.UserRepository;
import com.demo.carlease.service.LoginLogService;
import com.demo.carlease.service.UserService;
import com.demo.carlease.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {

    private final LoginLogService loginLogService;

    public UserServiceImpl(LoginLogService loginLogService) {
        this.loginLogService = loginLogService;
    }

    @Override
    public Boolean checkUserInfo(String username) {
        // 创建查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername, username);
        // 获取指定条件用户数据
        User user = getOne(wrapper);
        // 返回检查结果
        return Objects.nonNull(user);
    }

    @Override
    public Boolean checkUserById(Long id) {
        return Objects.nonNull(getById(id));
    }

    @Override
    public UserVO login(LoginDTO validator) {
        boolean exist = this.checkUserInfo(validator.getUsername());
        if (!exist) {
            throw new UserException("该用户不存在");
        }
        // 创建查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUsername, validator.getUsername()).eq(User::getPassword, validator.getPassword());
        // 获取指定条件用户信息
        User user = getOne(wrapper);
        if (Objects.isNull(user)) {
            throw new UserException("用户名或密码不正确");
        }
        // 返回结果封装
        UserVO result = new UserVO();
        BeanUtils.copyProperties(user, result);
        // 保存登录日志
        loginLogService.addLoginLog(result.getId());
        // 返回登录用户信息
        return result;
    }

    @Override
    @Transactional
    public Boolean register(RegisterDTO validator) {
        Boolean exist = this.checkUserInfo(validator.getUsername());
        if (exist) {
            throw new UserException("该用户已存在");
        }
        // 封装注册信息
        User user = new User();
        BeanUtils.copyProperties(validator, user);
        user.setCreateDatetime(LocalDateTime.now());
        // 新增用户信息
        return save(user);
    }

    @Override
    public List<UserVO> findAll() {
        List<User> users = this.list();
        List<UserVO> result = new ArrayList<>();
        users.forEach(user -> {
            UserVO u = new UserVO();
            BeanUtils.copyProperties(user, u);
            result.add(u);
        });
        return result;
    }

    @Override
    public UserVO update(UserInfoDTO validator) {
        // 获取原有用户信息
        User user = this.getById(validator.getId());
        // 修改用户昵称
        if (Objects.nonNull(validator.getNick())) {
            user.setNick(validator.getNick());
        }
        // 修改用户电话
        if (Objects.nonNull(validator.getPhone())) {
            user.setPhone(validator.getPhone());
        }
        // 修改用户邮箱
        if (Objects.nonNull(validator.getEmail())) {
            user.setEmail(validator.getEmail());
        }
        // 修改用户身份证号
        if (Objects.nonNull(validator.getCd())) {
            user.setCd(validator.getCd());
        }
        boolean result = this.updateById(user);
        if (result) {
            UserVO u = new UserVO();
            BeanUtils.copyProperties(this.getById(validator.getId()), u);
            return u;
        } else {
            return null;
        }
    }
}
