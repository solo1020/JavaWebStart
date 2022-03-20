package com.itcast.test;

import com.itcast.service.UserService;
import com.itcast.utils.LogUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName SpringImportBeanDefinitionRegisterTest
 * @description:
 * @author: isquz
 * @time: 2022/3/6
 */
public class SpringImportBeanDefinitionRegisterTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        // 使用ImportSelector进行注解的时候bean名称需要使用全路径名
//        UserService userService = ac.getBean("com.itcast.service.impl.UserServiceImpl", UserService.class);

        // 使用ImportBeanDefinitionRegistrar 注册器作为@Import的注解时 bean名称使用类名首字母小写
        UserService userService = ac.getBean("userServiceImpl", UserService.class);
        userService.saveUser();

        LogUtil logUtil = ac.getBean("logUtil", LogUtil.class);
        logUtil.pringLog();


    }
}
