package com.itcast.mybatis.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @ClassName UserDaoImpl
 * @description: 原始dao开发
 * @author: isquz
 * @time: 2021/10/31 23:16
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    public void insertUser(){
//        this.getSqlSession().insert();
    }
}
