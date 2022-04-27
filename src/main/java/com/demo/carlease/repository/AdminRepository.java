package com.demo.carlease.repository;

import com.demo.carlease.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Repository
public interface AdminRepository extends BaseMapper<Admin> {

}
