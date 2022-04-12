package com.itcast.test;

import com.itcast.HelloApplication;
import com.itcast.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName UserServiceTest
 * @description: UserService测试类
 * @author: isquz
 * @time: 2022/4/9
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }
}
