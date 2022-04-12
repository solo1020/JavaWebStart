package com.itcast.service;

import com.itcast.domain.Account;

import java.util.List;

/**
 * @ClassName AccountService
 * @description:
 * @author: isquz
 * @time: 2022/3/21
 */
public interface AccountService {
    void save(Account account);

    void update(Account account);

    void delete(Integer id);

    Account findById(Integer id);

    List<Account> findAllAccount();

}
