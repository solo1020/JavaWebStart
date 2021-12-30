package com.itcast.mapper;

import com.itcast.domain.Account;

import java.util.List;

/**
 * @ClassName AccountMapper
 * @description:
 * @author: isquz
 * @time: 2021/12/27 0:25
 */
public interface AccountMapper {

    public void save(Account account);

    public List<Account> findAll();
}
