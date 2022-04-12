package com.itcast.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName HelloApplicationTests
 * @description:
 * @author: isquz
 * @time: 2022/4/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSet(){
        // 存入数据
        redisTemplate.boundValueOps("name").set("zhangsan");
    }

    @Test
    public void testGet(){
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println("get: " + name);
    }

}
