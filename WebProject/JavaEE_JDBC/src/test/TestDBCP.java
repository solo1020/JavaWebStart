package test;

import JDBC.DBCPUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName TestDBCP
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/25 1:05
 * @Version 1.0
 **/
public class TestDBCP {
    @Test
    public void testUpdateUserById(){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBCPUtils.getConnection();
            String sql = "update tbl_user set upassword=? where uid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,"柳岩");
            ps.setInt(2,7);

            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("更新成功");
            }else {
                System.out.println("更新失败");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
