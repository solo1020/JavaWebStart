package com.itcast.dao.impl;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/16 0:13
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> list() {
        List<User> userList = jdbcTemplate.query("select * from sys_user",
                new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public Long save(User user) {
        // 创建PrepareStatementCreeator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // 使用原始jdbc完成一个PreparedStatement 组件
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setObject(2,user.getUsername());
                preparedStatement.setObject(3,user.getEmail());
                preparedStatement.setObject(4,user.getPassword());
                preparedStatement.setObject(5,user.getPhoneNum());

                return preparedStatement;
            }
        };

        // 创建KeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator,keyHolder);

        long userId = keyHolder.getKey().longValue();


//        jdbcTemplate.update("insert into system_user values (?,?,?,?)",null,
//                user.getUsername(),user.getEmail(), user.getPassword(), user.getPhoneNum());

        // 返回该新增user对象的id
        return userId;
    }

    @Override
    public void saveRoles(Long id, Long[] roleIds) {
        for(Long roleId: roleIds){
            jdbcTemplate.update("insert into sys_user_role values(?,?)", id, roleId);
        }

    }

    // 删除用户角色表sys_user_role
    @Override
    public void deleteUserRole(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?", userId);
    }

    /**
     * @description: 此处如果输入密码或用户名为空 则会导致EmptyResultDataAccessException 需要在service层进行处理
     * @param: username
     * @param: password
     * @return: com.itcast.domain.User
     * @author: isquz
     * @date: 2021/12/18 18:51
     */
    @Override
    public User login(String username, String password) throws EmptyResultDataAccessException {
        User user = jdbcTemplate.queryForObject("select * from sys_user where username=? and password=?",
                new BeanPropertyRowMapper<User>(User.class),
                username,password);
        return user;
    }

    // 删除用户
    @Override
    public void delete(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?",userId);
    }


}
