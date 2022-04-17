package com.itcast.test;

import com.itcast.domain.User;
import com.itcast.mapper.UserMapper;
import com.itcast.mapper.UserXmlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
    private UserXmlMapper userXmlMapper;

    // mybatis 通过xml配置映射查询
    @Test
    public void findAllFromMapperXml(){
        List<User> allUser = userXmlMapper.findAllUser();
        System.out.println(allUser);
    }

    @Autowired
    private UserMapper userMapper;

    // 注解方式mybatis查询
    @Test
    public void findAll(){
        List<User> allUser = userMapper.findAllUser();
        System.out.println(allUser);
    }

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
