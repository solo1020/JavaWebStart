package test;

import JDBC.C3P0Utils;
import JDBC.JDBCUtils_V3;
import JDBC.MyDataSource_1;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName TestC3P0
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/23 0:18
 * @Version 1.0
 **/
public class TestC3P0 {

    @Test
    public void testMyConnectionAddUser1(){
        Connection con = null;
        PreparedStatement ps = null;

        // 使用 c3p0 连接池 加载默认配置
//        DataSource dataSource = new ComboPooledDataSource();

        // 参数JavaEE 对应 xml 中的配置片段
//        DataSource dataSource = new ComboPooledDataSource("JavaEE");

        try {

//            con = dataSource.getConnection();

            // 在 C3P0Utils里面已经定义了getConnection方法所以上面的获取连接不需要再写
            con = C3P0Utils.getConnection();

            String sql = "insert into tbl_user values(null,?,?)";

            /**
             * description:
             * 因为这个 con 实际上已经是MyConnection对象
             * 所以直接调用 走的是 MyConnection类里面的 prepareStatemen()方法
             * 需要对该方法也进行改造重写
             */
            ps = con.prepareStatement(sql);

            ps.setString(1,"吕布3");
            ps.setString(2,"貂蝉3");
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            /**
             * description:
             *
             */
            JDBCUtils_V3.release(con,ps,null);
        }
    }



    @Test
    public void testMyConnectionAddUser(){
        Connection con = null;
        PreparedStatement ps = null;

        // 使用 c3p0 连接池 加载默认配置
        DataSource dataSource = new ComboPooledDataSource();

        // 参数JavaEE 对应 xml 中的配置片段
//        DataSource dataSource = new ComboPooledDataSource("JavaEE");

        try {
            con = dataSource.getConnection();
            String sql = "insert into tbl_user values(null,?,?)";

            /**
             * description:
             * 因为这个 con 实际上已经是MyConnection对象
             * 所以直接调用 走的是 MyConnection类里面的 prepareStatemen()方法
             * 需要对该方法也进行改造重写
             */
            ps = con.prepareStatement(sql);

            ps.setString(1,"吕布2");
            ps.setString(2,"貂蝉2");
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            /**
             * description:
             *
             */
            JDBCUtils_V3.release(con,ps,null);
        }
    }
}
