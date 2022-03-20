package com.itcast.test;

import config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName SpringConfigurationTest
 * @description: 测试Configuration注解
 * @author: isquz
 * @time: 2022/2/10 0:44
 */

public class SpringConfigurationTest {

    public static void main(String[] args) {

        // 使用扫描包的方式启动IOC容器
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
//        SpringConfiguration bean = ac.getBean(SpringConfiguration.class);
//        SpringConfiguration bean = ac.getBean("SpringConfiguration", SpringConfiguration.class);
//        System.out.println(bean);

        // 使用注解的字节码的方式启动IOC容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        SpringConfiguration bean = ac.getBean(SpringConfiguration.class);
        System.out.println(bean);
    }
}
