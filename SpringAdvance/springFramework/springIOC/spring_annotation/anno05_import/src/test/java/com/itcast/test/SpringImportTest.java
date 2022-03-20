package com.itcast.test;

import config.JdbcConfig;
import config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @ClassName SpringImportTest
 * @description: 测试@Import注解
 * @author: isquz
 * @time: 2022/2/27
 */


public class SpringImportTest {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        DataSource dataSource = ac.getBean("dataSource", DataSource.class );
        System.out.println(dataSource);

//        JdbcConfig config = ac.getBean( JdbcConfig.class);
        JdbcConfig config = ac.getBean("config.JdbcConfig", JdbcConfig.class);
        System.out.println("now JdbcConfig object: " + config);

        String[] names = ac.getBeanDefinitionNames();
        for(String bean: names){
            System.out.println(bean);
        }

    }
}
