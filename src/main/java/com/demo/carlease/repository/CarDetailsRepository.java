package com.demo.carlease.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.carlease.entity.CarDetails;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 汽车详情表 Mapper 接口
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/11
 */
@Repository
public interface CarDetailsRepository extends BaseMapper<CarDetails> {
}
