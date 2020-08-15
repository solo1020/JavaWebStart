package test;

import JDBC.JDBCUtils_V3;
import JDBC.MyDataSource;
import JDBC.MyDataSource_1;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName TestMyDataSource
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/21 22:54
 * @Version 1.0
 **/
public class TestMyDataSource {

    /**
     * description: 使用改造过close()方法的 MyConnection
     * @param
     * @return: void
     * @date: 2020/7/22 0:25
     * @author: qz
     */
    @Test
    public void testMyConnectionAddUser(){
        Connection con = null;
        PreparedStatement ps = null;
        MyDataSource_1 dataSource = new MyDataSource_1();
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


            ps.setString(1,"吕布1");
            ps.setString(2,"貂蝉1");
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
//            if (con != null){
//                try {
//                    con.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }

            /**
             * description:
             *
             */
            JDBCUtils_V3.release(con,ps,null);
        }
    }

    /**
     * description: 使用未改造close()方法的Connection
     * @param
     * @return: void
     * @date: 2020/7/22 0:24
     * @author: qz
     */
    @Test
    public void testAddUser(){
        Connection con = null;
        PreparedStatement ps = null;
        MyDataSource dataSource = new MyDataSource();
        try {
            con = dataSource.getConnection();
            String sql = "insert into tbl_user values(null,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,"吕布");
            ps.setString(2,"貂蝉");
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dataSource.backConnection(con);
        }
    }
}
