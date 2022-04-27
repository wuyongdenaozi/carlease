package com.demo.carlease.repository;

import com.demo.carlease.entity.CarType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 汽车类型表 Mapper 接口
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Repository
public interface CarTypeRepository extends BaseMapper<CarType> {

}
