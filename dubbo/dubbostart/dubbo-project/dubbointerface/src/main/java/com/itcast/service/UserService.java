package com.itcast.service;

import com.itcast.pojo.User;

/**
 * @ClassName UserService
 * @description:
 * @author: isquz
 * @time: 2022/5/1
 */
public interface UserService {
    public String sayHello();

    // 查询用户
    public User findUserById(int id);

}
