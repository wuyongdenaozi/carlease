package com.demo.carlease.controller;


import com.demo.carlease.exception.dto.OrdersDTO;
import com.demo.carlease.exception.ValidatorException;
import com.demo.carlease.service.OrdersService;
import com.demo.carlease.vo.OrdersVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 租赁订单表 前端控制器
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    /**
     * 添加新订单方法
     *
     * @param validator 用户提交订单校验器
     * @param result 数据验证结果
     * @return 订单提交结果
     */
    @PostMapping
    public boolean addOrder(@RequestBody @Validated OrdersDTO validator, BindingResult result) {
        if (result.getErrorCount() != 0) {
            throw new ValidatorException(result.getAllErrors());
        }
        return ordersService.add(validator);
    }

    /**
     * 获取所有订单方法
     * @return
     */
    @GetMapping
    public List<OrdersVO> getOrders() {
        return ordersService.getAllOrders();
    }

    /**
     * 通过用户 id 获取所有订单
     *
     * @return
     */
    @GetMapping("user/{userId}")
    public List<OrdersVO> getOrdersByUserId(@PathVariable("userId") Long userId) {
        return ordersService.getOrdersByUserId(userId);
    }
    /**
     * 通过汽车 id 获取所有订单
     *
     * @return
     */
    @GetMapping("car/{carId}")
    public List<OrdersVO> getOrdersByCarId(@PathVariable("carId") Long carId) {
        return ordersService.getOrdersByCarId(carId);
    }

}
