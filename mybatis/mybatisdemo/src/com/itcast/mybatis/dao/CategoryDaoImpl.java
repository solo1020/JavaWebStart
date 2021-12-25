package com.itcast.mybatis.dao;

import com.itcast.mybatis.pojo.Category;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @ClassName CategoryDaoImpl
 * @description:
 * @author: isquz
 * @time: 2021/9/29 23:14
 */


public class CategoryDaoImpl implements CategoryDao{
    // 注入
    private SqlSessionFactory sqlSessionFactory;

    public CategoryDaoImpl(){

    }

    public CategoryDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // 通过categoryid 查询
    public Category selectCategory(String id){
        SqlSession session = sqlSessionFactory.openSession();
        Category category = session.selectOne("test.findCategoryById", id);
        return category;
    }

    // 通过cname 模糊查询
    public List<Category> selectCategoryByCname(String cname){
        SqlSession session = sqlSessionFactory.openSession();
        return session.selectList("test.findCategoryBycname", cname);

    }


}
