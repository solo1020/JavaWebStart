package com.itcast.test;

import cofig.SpringConfiguration;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName SpringProfileTest
 * @description: 使用junit注解指定环境
 * @author: isquz
 * @time: 2022/3/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@ActiveProfiles("pro")
public class SpringProfileTest {

    @Autowired
    private DruidDataSource druidDataSource;

    @Test
    public void testDataSource(){
        System.out.println(druidDataSource.getMaxActive());
    }
}
