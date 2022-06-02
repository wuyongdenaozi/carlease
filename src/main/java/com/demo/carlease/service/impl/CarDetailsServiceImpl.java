package com.demo.carlease.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.carlease.dto.CarDTO;
import com.demo.carlease.dto.CarUpdateDTO;
import com.demo.carlease.entity.CarDetails;
import com.demo.carlease.repository.CarDetailsRepository;
import com.demo.carlease.service.CarDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 汽车详情表 服务实现类
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/11
 */
@Service
public class CarDetailsServiceImpl extends ServiceImpl<CarDetailsRepository, CarDetails> implements CarDetailsService {

    @Override
    public boolean addCarDetails(CarDTO validator, Long carId) {
        CarDetails carDetails = new CarDetails();
        BeanUtils.copyProperties(validator, carDetails);
        carDetails.setCarId(carId);
        carDetails.setCreateDatetime(LocalDateTime.now());
        return save(carDetails);
    }

    @Override
    public void updateDescribes(CarUpdateDTO validator) {
        LambdaUpdateWrapper<CarDetails> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(CarDetails::getCarId, validator.getId()).set(CarDetails::getDescribes, validator.getDescribes());
        this.update(wrapper);
    }
}
