package com.itcast.mybatis.mapper;

import com.itcast.mybatis.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MybatisMapperTest
 * @description:
 * @author: isquz
 * @time: 2021/10/2 22:34
 */
public class MybatisMapperTest {

    @Test
    public void testMapper() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        // SqlSession 自动生成实现类
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        Category category = categoryMapper.findCategoryById("567890");
        System.out.println(category);

    }

    @Test
    public void testCategoryWrapper() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        // SqlSession 自动生成实现类
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        QueryVo queryVo = new QueryVo();
        Category c = new Category();
//        c.setCid("567890");
        c.setCname("用品");
        queryVo.setCategory(c);
        List<Category> categoryList = categoryMapper.findCategoryByQueryVo(queryVo);
        for (Category category: categoryList){
            System.out.println(category);
        }
    }

    @Test
    public void testCountCategory() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        // SqlSession 自动生成实现类
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        Integer count = categoryMapper.countCategory();
        System.out.println("There are " + count + " categories");
    }


    // 查询所有order订单
    @Test
    public void testSelectOrders() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        // SqlSession 自动生成实现类
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        List<Orders> ordersList = mapper.selectOrdersList();
        for(Orders order : ordersList){
            System.out.println(order);
        }
    }

    // 查询商品
    @Test
    public void testSelectProduct() throws IOException, ParseException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        ProductMapper mapper = session.getMapper(ProductMapper.class);
        Product product = new Product();

        product.setPdate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-11-02"));
        product.setMarket_price(2699);

        List<Product> products = mapper.selectProductByDateAndMarketprice(product);
        for(Product p: products){
            System.out.println(p);
        }
    }

    // 查询多个pid的商品
    @Test
    public void testSelectProductPids() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        ProductMapper mapper = session.getMapper(ProductMapper.class);

//        QueryVo queryVo = new QueryVo();
//        List<String> pidList = new ArrayList<>();
//        pidList.add("1");
//        pidList.add("2");
//        pidList.add("11");
//        pidList.add("12");
//        pidList.add("13");
//        pidList.add("20");
//        queryVo.setPidList(pidList);
//        List<Product> products = mapper.selectProductByQueryVo(queryVo);

        String[] pids = new String[6];
        pids[0] = "1";
        pids[1] = "11";
        pids[2] = "12";
        pids[3] = "13";
        pids[4] = "2";
        pids[5] = "20";
        List<Product> products = mapper.selectProductByPids(pids);


        for(Product p : products){
            System.out.println(p);
        }

    }

    // 一对一关联left join查询
    @Test
    public void selectLeftJoinMyabtisOrderAndUser() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        MybatisOrderMapper mapper = session.getMapper(MybatisOrderMapper.class);
        List<MybatisOrder> orderList = mapper.selectMybatisOrders();

        for(MybatisOrder order: orderList){
            System.out.println(order);
        }

    }

    // 一对多关联left join查询
    @Test
    public void selectOrdersOfUser() throws IOException {
        // 加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        // 创建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建sqlsession
        SqlSession session = sessionFactory.openSession();

        MybatisOrderMapper mapper = session.getMapper(MybatisOrderMapper.class);
        List<MybatisUser> userList = mapper.selectMybatisUser();

        for(MybatisUser user: userList){
            System.out.println(user);
        }

    }
}
