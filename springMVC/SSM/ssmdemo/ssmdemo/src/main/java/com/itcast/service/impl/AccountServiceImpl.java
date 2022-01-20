package com.itcast.service.impl;

import com.itcast.domain.Account;
import com.itcast.mapper.AccountMapper;
import com.itcast.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName AccountServiceImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/28 22:01
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) {

        accountMapper.save(account);


//        try {
//            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//
//            SqlSession session = sqlSessionFactory.openSession();
//            AccountMapper mapper = session.getMapper(AccountMapper.class);
//
//            mapper.save(account);
//
//            session.commit();
//            session.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();

    }
}
