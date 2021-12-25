package com.itcast.service.impl;

import com.itcast.dao.RoleDao;
import com.itcast.dao.UserDao;
import com.itcast.domain.Role;
import com.itcast.domain.User;
import com.itcast.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/15 23:49
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.list();

        // 封装每个用户对应的角色
        for(User user: userList){
            // 通过id 查询对应的用户角色表
            Long id = user.getId();
            List<Role> roleList = roleDao.findRoleListByUserId(id);
            user.setUserRoles(roleList);
        }
        return userList;
    }

    /**
     * @description: 新增用户入库 用户基本信息入user表 角色信息要入 user_role表 并进行对应
     * @param: user
     * @param: roleIds
     * @return: void
     * @author: isquz
     * @date: 2021/12/16 21:09
     */
    @Override
    public void save(User user, Long[] roleIds) {
        Long userId = userDao.save(user);

        // 此时user.getId 无法获取到ID 因为user 的id是保存到数据库后自动生成的
        // 而用来存储到数据库的user对象本身立马并没有id
        // 所以应该在保存user对象到数据库的时候就返回一个id
        userDao.saveRoles(userId, roleIds);
    }

    @Override
    public void delete(Long userId) {
        // 删除用户角色关联表sys_user_role
        userDao.deleteUserRole(userId);
        // 删除用户sys_user
        userDao.delete(userId);
    }

    @Override
    public User login(String username, String password) {
//        return userDao.login(username,password);

        User user = null;
        try {
            user = userDao.login(username,password);
        }catch (EmptyResultDataAccessException ex){
            System.out.println("用户名或密码为空");
            return null;
        }
        return user;
    }
}
