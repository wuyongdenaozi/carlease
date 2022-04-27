package com.demo.carlease.service;

import com.demo.carlease.exception.dto.LoginDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 管理员服务测试类
 *
 * @author 李嘉明
 * create time 2021/12/21
 */
@SqlGroup({@Sql("classpath:sql/clean.sql"), @Sql("classpath:sql/AdminService/data.sql")})
@Transactional
@SpringBootTest
class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    void login() {
        LoginDTO validator = new LoginDTO();
        validator.setUsername("admin");
        validator.setPassword("admin");
        Boolean result = adminService.login(validator);
        assertTrue(result);

        validator.setUsername("bob");
        validator.setPassword("123456");
        result = adminService.login(validator);
        assertFalse(result);
    }
}