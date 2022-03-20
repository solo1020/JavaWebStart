package com.itcast.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName SpringPropertySourceTest
 * @description:
 * @author: isquz
 * @time: 2022/3/12
 */
public class SpringPropertySourceTest {

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");

        DataSource dataSource = ac.getBean("dataSource",DataSource.class);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
}
