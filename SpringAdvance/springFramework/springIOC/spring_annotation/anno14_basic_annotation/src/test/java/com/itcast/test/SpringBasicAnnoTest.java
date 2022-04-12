package com.itcast.test;

import com.itcast.domain.Account;
import com.itcast.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName SpringBasicAnnoTest
 * @description:
 * @author: isquz
 * @time: 2022/3/22
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringBasicAnnoTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("spring annotation");
        account.setMoney(11111d);
        accountService.save(account);
    }

    @Test
    public void testUpdate(){
        Account account = accountService.findById(5);
        account.setMoney(22222d);
        accountService.update(account);
    }

    @Test
    public void testDelete(){
        accountService.delete(5);
    }

    @Test
    public void testFindAccount(){
        Account account = accountService.findById(3);
        System.out.println(account);
    }

    @Test
    public void testFindAllAccout(){
        List<Account> accountList = accountService.findAllAccount();
        for(Account account : accountList){
            System.out.println(account);
        }
    }


}
