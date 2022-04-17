package com.itcast.springbootlistener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName MyApplicationContextInitializer
 * @description:
 * @author: isquz
 * @time: 2022/4/17
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer...init");
    }
}
