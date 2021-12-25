package com.itcast.mybatis.junit;

import com.itcast.mybatis.dao.CategoryDao;
import com.itcast.mybatis.dao.CategoryDaoImpl;
import com.itcast.mybatis.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MybatisDaoTest
 * @description:
 * @author: isquz
 * @time: 2021/9/30 22:55
 */
public class MybatisDaoTest {

    public SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void testDao(){

        CategoryDao categoryDao = new CategoryDaoImpl(sqlSessionFactory);
        Category category = categoryDao.selectCategory("567890");
        System.out.println(category);
    }
}
