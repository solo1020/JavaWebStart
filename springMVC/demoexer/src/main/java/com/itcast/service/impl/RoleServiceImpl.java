package com.itcast.service.impl;

import com.itcast.dao.RoleDao;
import com.itcast.domain.Role;
import com.itcast.service.RoleService;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/5 21:22
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        List<Role> roles = roleDao.findAll();
        return roles;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);

    }
}
