package JDBC;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @ClassName JDBCUtils_V2 通过读取配置文件获取 数据库连接
 * @Description TODO
 * @Author QA
 * @Date 2020/7/19 17:44
 * @Version 1.0
 **/
public class JDBCUtils_V2 {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    /**
     * description: 静态代码块加载配置文件信息
     * @date: 2020/7/19 17:49
     * @author: qz
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        username = bundle.getString("username");
        password = bundle.getString("password");
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
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
