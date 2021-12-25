package com.itcast.dao;

import com.itcast.domain.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @description:
 * @author: isquz
 * @time: 2021/12/16 0:13
 */
public interface UserDao {
    List<User> list();

    Long save(User user);

    void saveRoles(Long id, Long[] roleIds);

    void delete(Long userId);

    void deleteUserRole(Long userId);

    User login(String username, String password);
}
