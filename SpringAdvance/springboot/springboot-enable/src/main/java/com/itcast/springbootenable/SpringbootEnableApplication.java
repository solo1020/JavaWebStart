package com.itcast.springbootenable;

import com.itcast.config.*;
import com.itcast.doamin.Role;
import com.itcast.doamin.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.Jedis;

/**
 * @description:
 *
 * @ComponentScan 扫描范围： 当前引导类所在包及其子包
 * 也即是当前的com.itcast.springbootenable 包下的
 *
 * 解决方法：
 * 1. 使用@ComponentScan扫描 com.itcast.config 下导入的其他的module的包
 * @ComponentScan("com.itcast.config")
 * 2.使用@Import注解
 * @Import(UserConfig.class)
 * 3.对@Import注解进行封装 后再直接引用封装的注解
 * @EnableUser2
 *
 *
 * @author: isquz
 * @date: 2022/4/16 21:39
 */

//@ComponentScan("com.itcast.config")
//@Import(UserConfig.class)
//@EnableUser2
//@Import(User.class)
//@Import(UserConfig.class)
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistrar.class)
@SpringBootApplication
public class SpringbootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);

        Object user = context.getBean("user");
        System.out.println(user);

//        User bean = context.getBean(User.class);
//        System.out.println(bean);
//        System.out.println(context.getBeansOfType(User.class));

        Role bean1 = context.getBean(Role.class);
        System.out.println(bean1);

        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis);
        jedis.auth("Admin_test");

//        jedis.set("name", "itcast");
        System.out.println(jedis.get("name"));

    }

    // 此处方法名必须为jedis  与RedisAutoConfiguration中ConditionalOnMissingBean定义的一致
    @Bean
    public Jedis jedis(){
        return new Jedis("localhost",6379);
    }
}

