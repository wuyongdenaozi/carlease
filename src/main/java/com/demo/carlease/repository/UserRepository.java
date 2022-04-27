package com.demo.carlease.repository;

import com.demo.carlease.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Repository
public interface UserRepository extends BaseMapper<User> {

}
