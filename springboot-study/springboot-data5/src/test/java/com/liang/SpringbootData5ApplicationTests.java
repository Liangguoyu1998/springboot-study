package com.liang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
class SpringbootData5ApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        //查看一下默认的数据源
        System.out.println(dataSource);
        //获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //xxxx Template:SpringBoot已经配置好了模板bean,拿来即用，CRUD
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        connection.close();

    }

}
