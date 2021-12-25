package com.itcast.service;

import com.itcast.domain.User;

import java.util.List;

/**
 * @ClassName UserService
 * @description:
 * @author: isquz
 * @time: 2021/12/15 23:48
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);

    void delete(Long userId);

    User login(String username, String password);
}
