package JDBC;

import java.sql.*;

/**
 * @ClassName JDBCUtils_V1
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/15 9:19
 * @Version 1.0
 **/
public class JDBCUtils_V1 {

    /**
     * description:
     * @param
     * @return: java.sql.Connection
     * @date: 2020/7/15 9:23
     * @author: qz
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web06_1", "root", "qzqzqz");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection con, PreparedStatement ps, ResultSet rs){
            try {
                if(rs != null){
                    rs.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

    }

}
