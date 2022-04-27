package com.demo.carlease.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.carlease.entity.Orders;
import com.demo.carlease.vo.OrdersVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 租赁订单表 Mapper 接口
 * </p>
 *
 * @author 李嘉明
 * @since 2021-12-19
 */
@Repository
public interface OrdersRepository extends BaseMapper<Orders> {

    /**
     * 获取所有未完成订单
     *
     * @return
     */
    List<Orders> getOrdersByFlag();

    /**
     * 获取所有订单信息
     *
     * @return
     */
    List<OrdersVO> getAllOrders();

    List<OrdersVO> getOrdersByUserId(@Param("userId") Long userId);

    List<OrdersVO> getOrdersByCarId(@Param("carId") Long carId);
}
