package JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @ClassName JDBCUtils_V3
 * @Description TODO
 * @Author QA
 * @Date 2020/7/19 20:42
 * @Version 1.0
 **/
public class JDBCUtils_V3 {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    /**
     * description: 通过类加载器获取配置文件输入流
     * @date: 2020/7/19 20:48
     * @author: qz
     */
    static {
        try {
            // 通过当前类获取类加载器
            ClassLoader cl = JDBCUtils_V3.class.getClassLoader();

            // 通过类加载器获取 输入流
            InputStream is = cl.getResourceAsStream("db.properties");

            // 创建properties 对象
            Properties props = new Properties();

            // 加载输入流
            props.load(is);

            // 获取相关参数的值
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
