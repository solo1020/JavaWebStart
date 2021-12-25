package com.itcast.mybatis.junit;

import com.itcast.mybatis.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName MybatisFirstTest
 * @description:
 * @author: isquz
 * @time: 2021/8/29 14:51
 */
public class MybatisFirstTest {

    @Test
    public void testCategoryQuery() throws IOException {

        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        Category category = session.selectOne("test.findCategoryById", "567890");
        System.out.println(category);

    }

    // 根据cname 模糊查询category列表
    @Test
    public void testFindCategoryByName() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        List<Category> categoryList = session.selectList("test.findCategoryBycname","用品");
        System.out.println(categoryList);
        for(Category category : categoryList){
            System.out.println(category);
        }
    }

    // 添加category
    @Test
    public void addCategory() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        Category category = new Category();
        category.setCid(UUID.randomUUID().toString());
        category.setCname("testCategory"+ (int)(Math.random()*1000));
        int addRes = session.insert("test.addCategory", category);
        System.out.println("add category: " + category + " " + addRes);
        session.commit();
    }

    // 修改category
    @Test
    public void updateCategoryByCid() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        Category category = new Category();

        category.setCid("513e7b14-7d72-45c1-849a-b5a7881d442c");
        category.setCname("testCategory"+ (int)(Math.random()*1000));
        int addRes = session.update("test.updateCategoryByCid", category);
        System.out.println("update category: " + category + " " + addRes);
        session.commit();
    }

    // 删除category
    @Test
    public void deleteCategory() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        int addRes = session.delete("test.deleteCategory", "513e7b14-7d72-45c1-849a-b5a7881d442c");
        System.out.println("delete category: " + "513e7b14-7d72-45c1-849a-b5a7881d442c" + " result: " + addRes);
        session.commit();
    }
}
