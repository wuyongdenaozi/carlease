package com.demo.carlease.service;

import com.demo.carlease.dto.CarDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author 李嘉明
 * create time 2022/1/11
 */
@SqlGroup({@Sql("classpath:sql/clean.sql"), @Sql("classpath:sql/CarDetailsService/data.sql")})
@Transactional
@SpringBootTest
class CarDetailsServiceTest {

    @Autowired
    private CarDetailsService carDetailsService;

    @Test
    void addCarDetails() {
        CarDTO car = new CarDTO();
        car.setImg("dasdasd-sdadajpg");
        car.setDescribes("123");

        boolean result = carDetailsService.addCarDetails(car, 1L);

        assertTrue(result);
    }
}