package com.itcast.mybatis.dao;

import com.itcast.mybatis.pojo.Category;

/**
 * @ClassName CategoryDao
 * @description:
 * @author: isquz
 * @time: 2021/9/29 23:14
 */
public interface CategoryDao {

    public Category selectCategory(String id);
}
