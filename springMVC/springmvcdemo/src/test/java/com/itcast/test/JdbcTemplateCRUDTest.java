package com.itcast.test;

import com.itcast.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName JdbcTemplateCRUDTest
 * @description:
 * 1. 指定spring进行测试 @RunWith(SpringJUnit4ClassRunner.class) 首先添加spring-test依赖
 * 2. 设置配置文件
 * 3. 注入测试对象
 * @author: isquz
 * @time: 2021/12/2 23:04
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @description: 聚合查询
     * @param:
     * @return: void
     * @author: isquz
     * @date: 2021/12/2 23:38
     */
    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println("get all account num: " + count);
    }

    @Test
    public void testQueryOne(){
        Account lucy = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "lucy");
        System.out.println(lucy);
    }

    @Test
    public void testQuery(){
        List<Account> accountList = jdbcTemplate.query("select * from account ", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testUpdate(){
        int row = jdbcTemplate.update("update account set money=? where name=?",
                10000, "tom");
        System.out.println("update tom money row: " + row);
    }

    @Test
    public void testDelete(){
        int row = jdbcTemplate.update("delete from account where name=?", "tom-springmvc");
        System.out.println("delete tom-springmvc row: " + row);
    }
}
