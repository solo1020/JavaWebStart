package com.itcast.mybatis.mapper;

import com.itcast.mybatis.pojo.MybatisUser;

/**
 * @ClassName UserMapper
 * @description:
 * @author: isquz
 * @time: 2021/11/1 0:46
 */


public interface UserMapper {

    public MybatisUser findUserById(Integer id);
}
