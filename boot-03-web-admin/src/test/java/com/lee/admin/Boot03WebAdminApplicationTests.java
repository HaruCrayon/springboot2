package com.lee.admin;

import com.lee.admin.bean.User;
import com.lee.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class Boot03WebAdminApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from t_emp", Integer.class);
        log.info("查询到的记录数：{}", count);
        log.info("数据源：{}", dataSource.getClass());
    }

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(2L);
        log.info("查询到的用户：{}", user);
        List<User> userList = userMapper.selectList(null);
        log.info("查询到的用户列表：{}", userList);

    }
}
