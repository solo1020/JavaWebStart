package com.itcast.springbootlistener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName MyApplicationRunner
 * @description: 项目启动后执行run方法
 * @author: isquz
 * @time: 2022/4/18
 */

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner-ApplicationArguments...run");
        System.out.println(Arrays.toString(args.getSourceArgs()));
    }
}
