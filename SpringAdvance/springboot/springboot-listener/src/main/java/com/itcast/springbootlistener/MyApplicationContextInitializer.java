package com.itcast.springbootlistener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyApplicationContextInitializer
 * @description: 在创建IOC容器之前检测
 * @author: isquz
 * @time: 2022/4/17
 */

@Component
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer...init");
    }
}
