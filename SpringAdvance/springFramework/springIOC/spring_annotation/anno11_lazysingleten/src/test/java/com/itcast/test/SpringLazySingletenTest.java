package com.itcast.test;

import com.itcast.util.LogUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName SpringLazySingletenTest
 * @description:
 * @author: isquz
 * @time: 2022/3/14
 */


public class SpringLazySingletenTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        LogUtil logUtil = ac.getBean("logUtil", LogUtil.class);
        logUtil.printLog();

        LogUtil logUtil2 = ac.getBean("logUtil", LogUtil.class);
        System.out.println(logUtil == logUtil2);

    }
}
