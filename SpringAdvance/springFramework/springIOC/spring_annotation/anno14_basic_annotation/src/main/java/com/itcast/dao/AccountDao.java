package com.itcast.dao;

import com.itcast.domain.Account;

import java.util.List;

/**
 * @ClassName AccountDao
 * @description:
 * @author: isquz
 * @time: 2022/3/21
 */
public interface AccountDao {

    void save(Account account);

    void update(Account account);

    void delete(Integer id);

    Account findById(Integer id);

    List<Account> findAllAccount();
}
