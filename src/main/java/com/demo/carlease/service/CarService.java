package com.demo.carlease.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.carlease.dto.CarDTO;
import com.demo.carlease.dto.CarUpdateDTO;
import com.demo.carlease.entity.Car;
import com.demo.carlease.vo.CarVO;

import java.util.List;

/**
 * <p>
 * 汽车信息表 服务类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
public interface CarService extends IService<Car> {

    /**
     * 获取所有汽车信息
     *
     * @param type 列表排列类型
     * @return 汽车信息集合
     */
    List<CarVO> getAll(String type);

    CarVO getCar(Long carId);

    List<CarVO> getCarByUserId(Long userId);

    /**
     * 添加汽车信息
     *
     * @param validator 汽车信息校验器
     * @return 添加结果
     */
    boolean addCar(CarDTO validator);

    /**
     * 修改汽车信息
     *
     * @param validator 汽车修改信息校验器
     * @return 修改结果
     */
    boolean updateCarInfo(CarUpdateDTO validator);

    /**
     * 修改汽车租赁结果
     * @param carId 汽车 id
     * @return 修改结果
     */
    boolean buyCar(Long carId);

    /**
     * 刷新汽车状态
     */
    void refreshCarInfo();

    /**
     * 修改汽车状态为维修中
     * @param id 汽车 id
     * @return 修改结果
     */
    boolean deleteByCarId(Long id);

    /**
     * 恢复汽车的维修状态
     * @param id 汽车 id
     * @return 修改结果
     */
    boolean reDelete(Long id);
}
