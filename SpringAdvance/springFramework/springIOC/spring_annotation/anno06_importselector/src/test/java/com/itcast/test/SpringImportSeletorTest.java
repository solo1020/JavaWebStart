package com.itcast.test;

import com.itcast.service.UserService;
import com.itcast.utils.LogUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName SpringImportSeletorTest
 * @description:
 * @author: isquz
 * @time: 2022/3/6
 */
public class SpringImportSeletorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        UserService userService = ac.getBean("com.itcast.service.impl.UserServiceImpl", UserService.class);
        userService.saveUser();

        LogUtil logUtil = ac.getBean("com.itcast.utils.LogUtil", LogUtil.class);
        logUtil.pringLog();


    }
}
