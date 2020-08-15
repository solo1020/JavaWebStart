package JDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName C3P0Utils
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/24 0:27
 * @Version 1.0
 **/
public class C3P0Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("JavaEE");

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
//            throwables.printStackTrace();
        }
    }
}
