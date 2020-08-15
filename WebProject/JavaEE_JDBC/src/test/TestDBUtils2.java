package test;

import JDBC.C3P0Utils;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestDBUtils2
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/25 18:43
 * @Version 1.0
 **/
public class TestDBUtils2 {


    /**
     * description: 按列查询 不指定列的情况默认返回uid
     * @param
     * @return: void
     * @date: 2020/7/25 20:55
     * @author: qz
     */
    @Test
    public void testQueryAll_Version3(){
        try {
            // 1.创建核心类 QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            String sql = "select * from tbl_user";

            List<Object> list = qr.query(sql, new ColumnListHandler("uname"));
            for (Object obj : list){
                System.out.println(obj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * description:  查询所有用户 V2.0 返回map 集合
     * @param
     * @return: void     
     * @date: 2020/7/25 19:12
     * @author: qz
     */ 
    @Test
    public void testQueryAll_Version2(){
        try {
            // 1.创建核心类 QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            String sql = "select * from tbl_user";

            List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
            for (Map<String, Object> map : list){
                System.out.println(map);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * description: 查询用户总数
     * @param
     * @return: void
     * @date: 2020/7/25 19:07
     * @author: qz
     */
    @Test
    public void testQueryCount(){
        try {
            // 1.创建核心类 QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            String sql = "select count(*) from tbl_user";

            Long count = (Long) qr.query(sql, new ScalarHandler());


            System.out.println("There are " + count + " uesrs");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * description: 查询所有用户
     * @param
     * @return: void
     * @date: 2020/7/25 18:56
     * @author: qz
     */
    @Test
    public void testQueryAll(){
        try {
            // 1.创建核心类 QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            String sql = "select * from tbl_user";

            List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
            for (User user : users){
                System.out.println(user.getUname() + ": " + user.getUpassword());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * description: 根据uid查询用户
     * @param
     * @return: void
     * @date: 2020/7/25 19:03
     * @author: qz
     */
    @Test
    public void testQueryUserById(){
        try {
            // 1.创建核心类 QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            String sql = "select * from tbl_user where uid=?";

            Object[] params = {8};

            User user = qr.query(sql, new BeanHandler<User>(User.class), params);

            System.out.println(user.getUname() + ": " + user.getUpassword());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
