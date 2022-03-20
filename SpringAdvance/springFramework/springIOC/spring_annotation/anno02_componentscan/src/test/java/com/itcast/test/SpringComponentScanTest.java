package com.itcast.test;

import com.itcast.service.UserService;
import config.SpringConfiguration;
import com.itcast.utils.LogUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName SpringComponentScanTest
 * @description:
 * @author: isquz
 * @time: 2022/2/14 21:56
 */
public class SpringComponentScanTest {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        // 默认使用类名首字母小写 作为bean名词进行获取 如果需要自定义 需要在实现类的@Service注解中添加参数
        UserService userService = ac.getBean("myuserService", UserService.class);

        userService.saveUser();

//        AccountService accountService = ac.getBean("accountService", AccountService.class);
//        accountService.deleteAccount();

//        LogUtils logUtils = ac.getBean("logUtils", LogUtils.class);
        // 使用自定义的BeanName生成器 生成默认的beanName
        LogUtils logUtils = ac.getBean("mylogUtils", LogUtils.class);
        logUtils.printLog();

    }

}
