package com.itcast.mybatis.mapper;

import com.itcast.mybatis.pojo.MybatisOrder;
import com.itcast.mybatis.pojo.MybatisUser;

import java.util.List;

/**
 * @ClassName MybatisOrderMapper
 * @description:
 * @author: isquz
 * @time: 2021/10/19 23:48
 */
public interface MybatisOrderMapper {

    // 一对一关联left join查询 以订单查询用户mybatis_user表
    public List<MybatisOrder> selectMybatisOrders();

    // 一对多关联查询 以用户查询order表
    public List<MybatisUser> selectMybatisUser();
}
