package com.demo.carlease.controller;


import com.demo.carlease.dto.CarTypeDTO;
import com.demo.carlease.exception.ValidatorException;
import com.demo.carlease.service.CarTypeService;
import com.demo.carlease.vo.CarTypeVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 汽车类型表 前端控制器
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@RestController
@RequestMapping("/car-type")
public class CarTypeController {

    /** 汽车类型服务类 */
    private final CarTypeService carTypeService;

    public CarTypeController(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }

    /**
     * 获取所有汽车类型方法
     * @return 所有汽车类型
     */
    @GetMapping
    public List<CarTypeVO> findAllCarType() {
        return carTypeService.getAll();
    }

    /**
     * 新增汽车类型方法
     *
     * @param validator 新增汽车类型
     * @return 新增结果
     */
    @PostMapping
    public boolean addCarType(@RequestBody @Validated CarTypeDTO validator, BindingResult result) {
        if (result.getErrorCount() != 0) {
            throw new ValidatorException(result.getAllErrors());
        }
        return carTypeService.add(validator);
    }
}
