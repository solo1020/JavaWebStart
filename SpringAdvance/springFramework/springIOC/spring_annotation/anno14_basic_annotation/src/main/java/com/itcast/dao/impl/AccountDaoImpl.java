package com.itcast.dao.impl;

import com.itcast.dao.AccountDao;
import com.itcast.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName AccountDaoImpl
 * @description:
 * @author: isquz
 * @time: 2022/3/21
 */

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Account account) {
        jdbcTemplate.update("insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
    }

    public void update(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }

    public void delete(Integer id) {
        jdbcTemplate.update("delete from account where id=?", id);
    }

    public Account findById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id=?",
                new BeanPropertyRowMapper<Account>(Account.class)
                ,id);

        return accounts.isEmpty() ? null : accounts.get(0);
    }

    public List<Account> findAllAccount() {
        return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }
}
