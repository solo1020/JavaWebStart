package com.itcast.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * @ClassName JdbcTemplateTest
 * @description:
 * @author: isquz
 * @time: 2021/12/2 21:53
 */
public class JdbcTemplateTest {

    /**
     * @description: 通过spring容器产生JdbcTemplate对象
     * @param:
     * @return: void
     * @author: isquz
     * @date: 2021/12/2 22:57
     */
    @Test
    public void testJdbcTemplate2() throws PropertyVetoException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        // 执行操作
        int row = jdbcTemplate.update("insert into account values(?,?)",
                "dataSourceBean", 200);
        System.out.println("insert account row: " + row);
    }

    @Test
    public void testJdbcTemplate() throws PropertyVetoException {
        // 创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.2.110:3306/itcastshop");
        dataSource.setUser("root");
        dataSource.setPassword("admin");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源
        jdbcTemplate.setDataSource(dataSource);
        // 执行操作
        int row = jdbcTemplate.update("insert into account values(?,?)", "tom-springmvc", 5000);
        System.out.println("insert account row: " + row);
    }
}
