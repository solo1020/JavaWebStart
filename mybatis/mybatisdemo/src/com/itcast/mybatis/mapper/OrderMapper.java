package com.itcast.mybatis.mapper;

import com.itcast.mybatis.pojo.Orders;

import java.util.List;

/**
 * @ClassName OrderMapper
 * @description:
 * @author: isquz
 * @time: 2021/10/8 0:25
 */
public interface OrderMapper {

    public List<Orders> selectOrdersList();
}
