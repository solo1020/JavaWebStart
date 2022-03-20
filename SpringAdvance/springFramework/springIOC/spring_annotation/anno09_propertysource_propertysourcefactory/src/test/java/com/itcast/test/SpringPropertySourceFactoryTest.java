package com.itcast.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName SpringPropertySourceFactoryTest
 * @description:
 * @author: isquz
 * @time: 2022/3/13
 */
public class SpringPropertySourceFactoryTest {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        DataSource dataSource = (DataSource) ac.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        connection.close();
    }
}
