package com.itcast.mybatis.mapper;

import com.itcast.mybatis.pojo.Product;
import com.itcast.mybatis.pojo.QueryVo;

import java.util.List;

/**
 * @ClassName ProductMapper
 * @description:
 * @author: isquz
 * @time: 2021/10/8 23:31
 */
public interface ProductMapper {

    public List<Product> selectProductByDateAndMarketprice(Product p);

    // 根据pid查询product
    public List<Product> selectProductByPids(String[] pids);
//    public List<Product> selectProductByPidList(List<String> pids);
    public List<Product> selectProductByQueryVo(QueryVo vo);

}
