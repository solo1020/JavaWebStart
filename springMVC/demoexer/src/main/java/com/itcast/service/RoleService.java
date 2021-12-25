package com.itcast.service;

import com.itcast.domain.Role;

import java.util.List;

/**
 * @ClassName RoleService
 * @description:
 * @author: isquz
 * @time: 2021/12/5 21:14
 */
public interface RoleService {

    public List<Role> list();

    void save(Role role);
}
