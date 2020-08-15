package test;

import JDBC.JDBCUtils_V1;
import JDBC.JDBCUtils_V2;
import JDBC.JDBCUtils_V3;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName TestUtils
 * @Description
 * @Author QZ
 * @Date 2020/7/18 20:32
 * @Version 1.0
 **/
public class TestUtils {
    @Test
    public void testUpdateById(){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = JDBCUtils_V3.getConnection();
            String sql = "update tbl_user set upassword=? where uid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "999");
            ps.setInt(2,3);

            int row = ps.executeUpdate();
            if(row > 0){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils_V3.release(con, ps, null);
        }
    }



    /**
     * description: 根据id 删除数据
     * @param
     * @return: void
     * @date: 2020/7/19 20:49
     * @author: qz
     */
    @Test
    public void testDeleteById(){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = JDBCUtils_V3.getConnection();
            String sql = "delete from tbl_user where uid=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 4);

            int row = ps.executeUpdate();
            if(row > 0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils_V3.release(con, ps, null);
        }
    }

    /**
     * description: 
     * @param
     * @return: void     
     * @date: 2020/7/19 17:51
     * @author: qz
     */ 
    @Test
    public void testAdd(){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = JDBCUtils_V2.getConnection();
            String sql = "insert into tbl_user values(null, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, "lisi");
            ps.setString(2,"hehe");

            int row = ps.executeUpdate();
            if(row > 0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils_V2.release(con, ps, null);
        }
    }


    /**
     * description:
     * @param
     * @return: void
     * @date: 2020/7/19 17:00
     * @author: qz
     */
    @Test
    public void testFindUserById() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // 1.获取连接
            con = JDBCUtils_V1.getConnection();
            // 2.编写sql
            String sql = "select * from tbl_user where uid=?";
            // 3.获取执行sql语句对象
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2);

            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(2) + "----" + rs.getString("upassword"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils_V1.release(con, ps, rs);
        }
    }

}
