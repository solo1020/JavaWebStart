package test;

import JDBC.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @ClassName TestDBUtils
 * @Description 测试DBUtils工具类
 * @Author QZ
 * @Date 2020/7/25 17:54
 * @Version 1.0
 **/
public class TestDBUtils {

    @Test
    public void testDeleteUserById(){
        try {
            // 1.创建核心类 QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            String sql = "delete from tbl_user where uid=?";

            Object[] params = {6};
            int rows = qr.update(sql,params);
            if(rows > 0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    public void testUpdateUserById(){
        try {
            // 1.创建核心类 QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            String sql = "update tbl_user set upassword=? where uid=?";

            Object[] params = {"xxx",8};
            int rows = qr.update(sql,params);
            if(rows > 0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * description: 添加用户
     * @param
     * @return: void
     * @date: 2020/7/25 18:02
     * @author: qz
     */
    @Test
    public void testAddUser(){
        try {
            // 1.创建核心类 QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

            String sql = "insert into tbl_user values(null,?,?)";

            Object[] params = {"余淮","耿耿"};
            int rows = qr.update(sql,params);
            if(rows > 0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
