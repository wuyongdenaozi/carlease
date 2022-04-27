package com.demo.carlease.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.carlease.exception.dto.LoginDTO;
import com.demo.carlease.exception.dto.RegisterDTO;
import com.demo.carlease.exception.dto.UserInfoDTO;
import com.demo.carlease.entity.User;
import com.demo.carlease.vo.UserVO;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
public interface UserService extends IService<User> {

    /**
     * 用户信息校验方法
     *
     * @param username 用户名称
     * @return 用户校验结果 true | false
     */
    Boolean checkUserInfo(String username);

    Boolean checkUserById(Long id);

    /**
     * 用户登录方法
     *
     * @param validator 用户登录信息校验器
     * @return 获取到的用户数据
     */
    UserVO login(LoginDTO validator);

    /**
     * 用户注册方法
     *
     * @param validator 用户注册信息校验器
     * @return 获取到的注册信息
     */
    Boolean register(RegisterDTO validator);

    /**
     * 获取所有用户信息方法
     *
     * @return 用户信息集合
     */
    List<UserVO> findAll();

    /**
     * 用户信息修改方法
     *
     * @param validator 用户信息校验器
     * @return 修改结果
     */
    UserVO update(UserInfoDTO validator);

}
