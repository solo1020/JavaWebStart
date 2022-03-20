package com.itcast.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @ClassName SpringConditionalTest
 * @description:
 * @author: isquz
 * @time: 2022/3/19
 */
public class SpringConditionalTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        DataSource dataSource = ac.getBean("dataSource", DataSource.class);
        System.out.println(dataSource);
    }
}
