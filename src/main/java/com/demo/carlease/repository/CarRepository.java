package com.demo.carlease.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.carlease.entity.Car;
import com.demo.carlease.vo.CarVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 汽车信息表 Mapper 接口
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Repository
public interface CarRepository extends BaseMapper<Car> {

    List<CarVO> getAll();

    List<CarVO> getCarsOnHot();

    List<CarVO> getCarsOnCount();

    List<CarVO> getCarsOnUserId(@Param("userId") Long userId);

    CarVO getCarById(@Param("carId") Long carId);
}
