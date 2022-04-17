package com.itcast.redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @ClassName RedisAutoConfiguration
 * @description:
 * @author: isquz
 * @time: 2022/4/17
 */

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnClass(Jedis.class)
public class RedisAutoConfiguration {

    //提供jedis的bean
    @Bean
    // 当前jedis 仅在用户没有自行定义的时候作为默认 情况 进行提供
    @ConditionalOnMissingBean(name = "jedis")
    public Jedis jedis(RedisProperties redisProperties){
        System.out.println("RedisAutoConfiguration...");
        return new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }
}
