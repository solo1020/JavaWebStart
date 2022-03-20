package com.itcast.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName SpringDependsOnTest
 * @description:
 * @author: isquz
 * @time: 2022/3/14
 */
public class SpringDependsOnTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        ac.start();
    }
}
