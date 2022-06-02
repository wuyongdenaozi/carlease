package com.demo.carlease.service;

import com.demo.carlease.dto.LoginDTO;
import com.demo.carlease.dto.RegisterDTO;
import com.demo.carlease.dto.UserInfoDTO;
import com.demo.carlease.exception.UserException;
import com.demo.carlease.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试类
 *
 * @author 李嘉明
 * create time 2021/12/20
 */
@SqlGroup({@Sql("classpath:sql/clean.sql"), @Sql("classpath:sql/UserService/data.sql")})
@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void checkUserInfo() {
        String username = "john";
        Boolean exist = userService.checkUserInfo(username);
        assertTrue(exist);

        username = "tom";
        exist = userService.checkUserInfo(username);
        assertTrue(exist);

        username = "mark";
        exist = userService.checkUserInfo(username);
        assertFalse(exist);
    }

    @Test
    void login() {
        LoginDTO validator = new LoginDTO();
        validator.setUsername("john");
        validator.setPassword("123456");

        UserVO user = userService.login(validator);
        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals("John", user.getNick());
        assertEquals("13323332333", user.getPhone());
        assertEquals("123456@qq.com", user.getEmail());

        validator.setUsername("mark");
        validator.setPassword("abcdef");
        String msg = assertThrows(UserException.class, () -> userService.login(validator)).getMessage();
        assertEquals("该用户不存在", msg);
    }

    @Test
    void register() {
        RegisterDTO validator = new RegisterDTO();
        validator.setUsername("mark");
        validator.setPassword("abcdef");
        validator.setNick("Mark");
        validator.setPhone("12222222222");
        validator.setEmail("abcdef@mark.com");

        Boolean result = userService.register(validator);
        assertTrue(result);

        validator.setUsername("john");
        String msg = assertThrows(UserException.class, () -> userService.register(validator)).getMessage();
        assertEquals("该用户已存在", msg);
    }

    @Test
    void findAll() {
        List<UserVO> users = userService.findAll();

        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    void update() {
        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setId(1L);
        userInfo.setNick("Mark");
        UserVO user = userService.update(userInfo);

        assertNotNull(user);
        assertEquals("Mark", user.getNick());
        assertEquals("13323332333", user.getPhone());
        assertEquals("123456@qq.com", user.getEmail());
    }
}