package com.itcast.springbootcondition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootConditionApplication {

    public static void main(String[] args) {
        // 返回spring IOC容器
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootConditionApplication.class, args);

        // 获取redisTemplate bean
//        Object redisTemplate = applicationContext.getBean("redisTemplate");
//        System.out.println(redisTemplate);

//        Object user = applicationContext.getBean("user");
        Object user = applicationContext.getBean("user2");
        System.out.println(user);


    }


}
