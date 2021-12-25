package com.itcast.dao;

import com.itcast.domain.Role;

import java.util.List;

/**
 * @ClassName RoleDao
 * @description:
 * @author: isquz
 * @time: 2021/12/7 0:31
 */
public interface RoleDao {

    public List<Role> findAll();

    void save(Role role);

    List<Role> findRoleListByUserId(Long id);
}
