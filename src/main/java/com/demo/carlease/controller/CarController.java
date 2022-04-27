package com.demo.carlease.controller;

import com.demo.carlease.dto.DeleteCarsInfo;
import com.demo.carlease.exception.dto.CarDTO;
import com.demo.carlease.exception.dto.CarUpdateDTO;
import com.demo.carlease.exception.ValidatorException;
import com.demo.carlease.service.CarService;
import com.demo.carlease.vo.CarVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 汽车信息表 前端控制器
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@RestController
@RequestMapping("/car")
public class CarController {

    /** 汽车信息服务类 */
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * 获取所有汽车数据方法
     *
     * @return
     */
    @GetMapping
    public List<CarVO> findAllCar() {
        return carService.getAll("");
    }

    /**
     * 获取当前新上市汽车前五条记录
     *
     * @return
     */
    @GetMapping("/hot")
    public List<CarVO> findAllCarByHot() {
        return carService.getAll("hot");
    }

    /**
     * 获取租赁次数最多的汽车前五条记录
     *
     * @return
     */
    @GetMapping("/count")
    public List<CarVO> findAllCarByCount() {
        return carService.getAll("count");
    }

    /**
     * 通过汽车编号获取指定汽车信息
     *
     * @param carId
     * @return
     */
    @GetMapping("/{carId}")
    public CarVO findCar(@PathVariable("carId") Long carId) {
        return carService.getCar(carId);
    }

    /**
     * 获取当前用户的所有汽车信息
     *
     * @return
     */
    @GetMapping("/user/{userId}")
    public List<CarVO> findAllCarByUser(@PathVariable("userId") Long userId) {
        return carService.getCarByUserId(userId);
    }

    /**
     * 添加新的汽车信息
     * @param validator
     * @return
     */
    @PostMapping
    public boolean addCar(@RequestBody @Validated CarDTO validator, BindingResult result) {
        if (result.getErrorCount() != 0) {
            throw new ValidatorException(result.getAllErrors());
        }
        return carService.addCar(validator);
    }

    @PutMapping
    public boolean updateCar(@RequestBody @Validated CarUpdateDTO validator, BindingResult result) {
        if (result.getErrorCount() != 0) {
            throw new ValidatorException(result.getAllErrors());
        }
        return carService.updateCarInfo(validator);
    }

    @PostMapping("/del")
    public void deleteCars(@RequestBody DeleteCarsInfo carsInfo) {
        if (Objects.nonNull(carsInfo) && Objects.nonNull(carsInfo.getCarIdList()) && carsInfo.getCarIdList().size() != 0) {
            carsInfo.getCarIdList().forEach(this::deleteCar);
        }
    }

    @DeleteMapping("/{id}")
    public boolean deleteCar(@PathVariable("id") Long id) {
        return carService.removeById(id);
    }

}
