package com.demo.carlease.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.carlease.exception.dto.CarDTO;
import com.demo.carlease.exception.dto.CarUpdateDTO;
import com.demo.carlease.entity.Car;
import com.demo.carlease.entity.Orders;
import com.demo.carlease.repository.CarRepository;
import com.demo.carlease.service.*;
import com.demo.carlease.vo.CarVO;
import com.demo.carlease.vo.FileVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 汽车信息表 服务实现类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarRepository, Car> implements CarService {

    private final CarRepository carRepository;

    private final CarDetailsService carDetailsService;

    private final UserService userService;

    private final OrdersService ordersService;

    private final FileService fileService;

    public CarServiceImpl(CarRepository carRepository, CarDetailsService carDetailsService, UserService userService, OrdersService ordersService, FileService fileService) {
        this.carRepository = carRepository;
        this.carDetailsService = carDetailsService;
        this.userService = userService;
        this.ordersService = ordersService;
        this.fileService = fileService;
    }

    @Override
    public List<CarVO> getAll(String type) {
        this.refreshCarInfo();
        type = type.toLowerCase();

        List<CarVO> cars = new ArrayList<>();

        switch (type) {
            case "hot":
                cars = carRepository.getCarsOnHot();
                break;
            case "count":
                cars = carRepository.getCarsOnCount();
                break;
            default:
                cars = carRepository.getAll();
                break;
        }
//        List<CarVO> cars = switch (type) {
//            case "hot" -> carRepository.getCarsOnHot();
//            case "count" -> carRepository.getCarsOnCount();
//            default -> carRepository.getAll();
//        };
        return updateCarImg(cars);
    }

    @Override
    public CarVO getCar(Long carId) {
        this.refreshCarInfo();
        CarVO carVO = carRepository.getCarById(carId);
        carVO.setImg(fileService.download(carVO.getImg()).getFileName());
        return carVO;
    }

    @Override
    public List<CarVO> getCarByUserId(Long userId) {
        this.refreshCarInfo();
        if (userService.checkUserById(userId)) {
            List<CarVO> cars = carRepository.getCarsOnUserId(userId);
            return updateCarImg(cars);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean addCar(CarDTO validator) {
        Car car = new Car();
        BeanUtils.copyProperties(validator, car);
        car.setNumber(0);
        car.setFlag(false);
        car.setCreateDatetime(LocalDateTime.now());
        boolean result = this.save(car);
        if (result) {
            LambdaQueryWrapper<Car> wrapper = Wrappers.lambdaQuery();
            wrapper.eq(Car::getName, validator.getName());
            Car c = getOne(wrapper);
            result = carDetailsService.addCarDetails(validator, c.getId());
            return result;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean updateCarInfo(CarUpdateDTO validator) {
        Car car = this.getById(validator.getId());
        if (Objects.isNull(car)) {
            return false;
        }
        LambdaUpdateWrapper<Car> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Car::getId, validator.getId());
        if (Objects.nonNull(validator.getAddress())) {
            wrapper.set(Car::getAddress, validator.getAddress());
        }
        if (Objects.nonNull(validator.getPrice())) {
            wrapper.set(Car::getPrice, validator.getPrice());
        }
        if (Objects.nonNull(validator.getDescribes())) {
            carDetailsService.updateDescribes(validator);
        }
        return this.update(wrapper);
    }

    @Override
    public boolean buyCar(Long carId) {
        this.refreshCarInfo();
        Car car = getById(carId);
        LambdaUpdateWrapper<Car> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Car::getId, carId).set(Car::getFlag, true).set(Car::getNumber, car.getNumber() + 1);
        return this.update(wrapper);
    }

    @Override
    public void refreshCarInfo() {
        List<Orders> orders = ordersService.getOrdersByFlag();
        orders.forEach(order -> {
            LocalDateTime finishDatetime = order.getCreateDatetime().plusDays(order.getDate());
            if (LocalDateTime.now().isAfter(finishDatetime)) {
                // 订单已经完成
                ordersService.finish(order.getId());
                LambdaUpdateWrapper<Car> wrapper = new LambdaUpdateWrapper<>();
                wrapper.eq(Car::getId, order.getCarId()).set(Car::getFlag, false);
                this.update(wrapper);
            }
        });
    }


    /**
     * 获取图片文件并进行转码
     *
     * @param cars 待修改信息
     * @return 修改后信息
     */
    private List<CarVO> updateCarImg(List<CarVO> cars) {
        cars.forEach(car -> {
            FileVO file = fileService.download(car.getImg());
            if (Objects.nonNull(file)) {
                car.setImg(file.getFileName());
            }
        });
        return cars;
    }
}
