package com.demo.carlease.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.carlease.dto.OrdersDTO;
import com.demo.carlease.entity.Orders;
import com.demo.carlease.vo.OrdersVO;

import java.util.List;

/**
 * <p>
 * 租赁订单表 服务类
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
public interface OrdersService extends IService<Orders> {

    /**
     * 添加新订单方法
     *
     * @return
     * @param validator
     */
    boolean add(OrdersDTO validator);

    /**
     * 获取所有未完成订单
     *
     * @return
     */
    List<Orders> getOrdersByFlag();

    /**
     * 获取所有订单信息
     * @return
     */
    List<OrdersVO> getAllOrders();

    /**
     * 订单完成方法
     *
     * @param orderId
     * @return 完成结果
     */
    boolean finish(Long orderId);

    List<OrdersVO> getOrdersByCarId(Long carId);

    List<OrdersVO> getOrdersByUserId(Long userId);
}
