package com.demo.carlease.repository;

import com.demo.carlease.entity.LoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.carlease.vo.LoginLogVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 管理员登录日志 Mapper 接口
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Repository
public interface LoginLogRepository extends BaseMapper<LoginLog> {

    List<LoginLogVO> getAll();

}
