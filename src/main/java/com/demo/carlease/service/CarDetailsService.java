package com.demo.carlease.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.carlease.dto.CarDTO;
import com.demo.carlease.dto.CarUpdateDTO;
import com.demo.carlease.entity.CarDetails;

/**
 * <p>
 * 汽车详情表 服务类
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/11
 */
public interface CarDetailsService extends IService<CarDetails> {

    /**
     * 添加汽车详情方法
     * @param validator 汽车详情校验器
     * @return 添加结果
     */
    boolean addCarDetails(CarDTO validator, Long carId);

    void updateDescribes(CarUpdateDTO validator);
}
