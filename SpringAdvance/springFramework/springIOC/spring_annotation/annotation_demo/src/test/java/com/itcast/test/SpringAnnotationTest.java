package com.itcast.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName SpringAnnotationTest
 * @description: 测试spring注解驱动开发
 * @author: isquz
 * @time: 2022/2/9 1:16
 */
public class SpringAnnotationTest {

    public static void main(String[] args) {
        // 创建容器 基于注解的创建方式
        // config包下哪个类存在 @Configuration注解就会被扫描
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");

        // 根据bean的ID获取对象
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // 执行操作
        String sql = "insert into account(name, money) values(?,?)";
        jdbcTemplate.update(sql, "test", 12345);

    }
}
