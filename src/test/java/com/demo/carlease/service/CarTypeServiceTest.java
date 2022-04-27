package com.demo.carlease.service;

import com.demo.carlease.vo.CarTypeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 李嘉明
 * create time 2021/12/22
 */
@SqlGroup({@Sql("classpath:sql/clean.sql"), @Sql("classpath:sql/CarTypeService/data.sql")})
@Transactional
@SpringBootTest
class CarTypeServiceTest {

    @Autowired
    private CarTypeService carTypeService;

    @Test
    void getAll() {
        List<CarTypeVO> carTypes = carTypeService.getAll();
        assertNotNull(carTypes);
        assertEquals(2, carTypes.size());
    }
}