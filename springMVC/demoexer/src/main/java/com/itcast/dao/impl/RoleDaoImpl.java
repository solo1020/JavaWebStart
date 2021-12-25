package com.itcast.dao.impl;

import com.itcast.dao.RoleDao;
import com.itcast.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName RoleDaoImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/7 0:32
 */
public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        System.out.println("get roleList: " + roleList);
        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)",
                null,role.getRoleName(),  role.getRoleDesc());

    }

    @Override
    public List<Role> findRoleListByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query("select r.id,r.roleName, r.roleDesc from sys_role r, sys_user_role ur where ur.roleId=r.id and ur.userId = ?",
                new BeanPropertyRowMapper<Role>(Role.class), id);
        System.out.println("get roles of Id: " + id + "--- " + roles);
        return roles;
    }
}
