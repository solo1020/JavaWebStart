package com.itcast.service.impl;

import com.itcast.domain.Account;
import com.itcast.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AccountServiceImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/28 22:01
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Override
    public void save(Account account) {

    }

    @Override
    public List<Account> findAll() {
        return null;
    }
}
