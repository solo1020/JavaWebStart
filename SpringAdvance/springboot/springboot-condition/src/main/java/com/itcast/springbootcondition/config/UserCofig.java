package com.itcast.springbootcondition.config;

import com.itcast.springbootcondition.condition.ClassCondition;
import com.itcast.springbootcondition.condition.ConditionOnClass;
import com.itcast.springbootcondition.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName UserCofig
 * @description:
 * @author: isquz
 * @time: 2022/4/16
 */

@Configuration
public class UserCofig {
    @Bean
    // 注解属性返回false 不会创建该bean
//    @Conditional(ClassCondition.class)
//    @ConditionOnClass("redis.clients.jedis.Jedis")
    @ConditionOnClass("com.alibaba.fastjson.JSON")
    public User user(){
        return new User();
    }

    @Bean@ConditionalOnProperty(name = "itcast", havingValue = "itcast")
    public User user2(){
        return new User();
    }
}
