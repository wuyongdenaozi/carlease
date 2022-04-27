package com.demo.carlease.service.impl;

import com.demo.carlease.exception.dto.CarTypeDTO;
import com.demo.carlease.entity.CarType;
import com.demo.carlease.repository.CarTypeRepository;
import com.demo.carlease.service.CarTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.carlease.vo.CarTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 汽车类型表 服务实现类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Service
public class CarTypeServiceImpl extends ServiceImpl<CarTypeRepository, CarType> implements CarTypeService {

    @Override
    public List<CarTypeVO> getAll() {
        // 获取数据库中汽车类型信息
        List<CarType> carTypes = list();
        // 创建返回结果集
        List<CarTypeVO> result = new ArrayList<>();
        // 循环遍历并赋值
        carTypes.forEach(type -> {
            CarTypeVO carTypeVO = new CarTypeVO();
            BeanUtils.copyProperties(type, carTypeVO);
            result.add(carTypeVO);
        });
        // 返回查询结果
        return result;
    }

    @Override
    public boolean add(CarTypeDTO validator) {
        CarType carType = new CarType();
        carType.setName(validator.getName());
        carType.setCreateDatetime(LocalDateTime.now());
        return this.save(carType);
    }
}
