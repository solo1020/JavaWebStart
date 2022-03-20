package com.itcast.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @ClassName SpringBeanTest
 * @description:
 * @author: isquz
 * @time: 2022/2/22 23:46
 */
public class SpringBeanTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");

//        DataSource dataSource = ac.getBean("dataSource", DataSource.class);
//        System.out.println(dataSource);

        // 获取JdbcTemplate对象
        JdbcTemplate jdbcTemplate = ac.getBean("createJdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate.getDataSource());
    }
}
