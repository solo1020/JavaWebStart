package com.itcast.service;

import com.itcast.domain.Account;

import java.util.List;

/**
 * @ClassName AccountService
 * @description:
 * @author: isquz
 * @time: 2021/12/28 21:32
 */
public interface AccountService {

    public void save(Account account);

    public List<Account> findAll();
}
