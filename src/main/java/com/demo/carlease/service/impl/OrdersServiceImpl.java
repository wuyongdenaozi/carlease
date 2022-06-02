package com.demo.carlease.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.carlease.dto.OrdersDTO;
import com.demo.carlease.entity.Orders;
import com.demo.carlease.repository.OrdersRepository;
import com.demo.carlease.service.CarService;
import com.demo.carlease.service.OrdersService;
import com.demo.carlease.vo.OrdersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 租赁订单表 服务实现类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersRepository, Orders> implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    @Lazy
    private CarService carService;

    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    @Transactional
    public boolean add(OrdersDTO validator) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(validator, orders);
        orders.setCreateDatetime(LocalDateTime.now());
        return save(orders) && this.carService.buyCar(orders.getCarId());
    }

    @Override
    public List<Orders> getOrdersByFlag() {
        return ordersRepository.getOrdersByFlag();
    }

    @Override
    public List<OrdersVO> getAllOrders() {
        carService.refreshCarInfo();
        return ordersRepository.getAllOrders();
    }

    @Override
    public boolean finish(Long orderId) {
        LambdaUpdateWrapper<Orders> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Orders::getId, orderId).set(Orders::getFlag, true);
        return update(wrapper);
    }

    @Override
    public List<OrdersVO> getOrdersByCarId(Long carId) {
        carService.refreshCarInfo();
        return ordersRepository.getOrdersByCarId(carId);
    }

    @Override
    public List<OrdersVO> getOrdersByUserId(Long userId) {
        carService.refreshCarInfo();
        return ordersRepository.getOrdersByUserId(userId);
    }
}
