package com.itcast.service.impl;

import com.itcast.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @ClassName AccountServiceImpl
 * @description:
 * @author: isquz
 * @time: 2022/2/14 22:34
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    public void deleteAccount() {
        System.out.println("delete account...");
    }
}
