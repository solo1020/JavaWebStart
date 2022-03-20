package com.itcast.service.impl;

import com.itcast.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @description:
 * @author: isquz
 * @time: 2022/2/14 22:01
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    public void saveUser() {
        System.out.println("implmented save()");
    }
}
