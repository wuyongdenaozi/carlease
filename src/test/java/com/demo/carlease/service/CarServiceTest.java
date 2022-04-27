package com.demo.carlease.service;

import com.demo.carlease.vo.CarVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author 李嘉明
 * create time 2021/12/22
 */
@SqlGroup({@Sql("classpath:sql/clean.sql"), @Sql("classpath:sql/CarService/data.sql")})
@Transactional
@SpringBootTest
class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    void getAll() {
        List<CarVO> cars = carService.getAll("hot");
        assertNotNull(cars);
        assertEquals(1, cars.size());
    }
}