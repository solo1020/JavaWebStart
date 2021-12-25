package com.itcast.mybatis.junit;

import com.itcast.mybatis.mapper.UserMapper;
import com.itcast.mybatis.pojo.MybatisUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName JunitTest
 * @description:
 * @author: isquz
 * @time: 2021/11/1 22:45
 */
public class JunitTest {

    @Test
    public void testAgentMapper(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = context.getBean(UserMapper.class);
//        UserMapper mapper = (UserMapper) context.getBean("userMapper");
        MybatisUser user = mapper.findUserById(10);
        System.out.println(user);
    }
}
