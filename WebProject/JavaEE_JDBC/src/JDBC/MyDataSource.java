package JDBC;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @ClassName MyDataSource
 * @Description TODO
 * @Author QA
 * @Date 2020/7/19 22:25
 * @Version 1.0
 **/
public class MyDataSource implements DataSource {

    private static LinkedList<Connection> pool = new LinkedList<>();

    static{
        for (int i = 0; i < 5; i++) {
            Connection con = JDBCUtils_V3.getConnection();
            pool.add(con);
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        Connection con = null;
        if(pool.size() == 0){
            for (int i = 0; i < 5; i++) {
                con = JDBCUtils_V3.getConnection();
                pool.add(con);
            }
        }
        // 从连接池中获取一个链接对象Connection
        con = pool.remove(0);
        return con;
    }

    /**
     * description: 将连接对象返回到连接池
     * @param con
     * @return: void     
     * @date: 2020/7/20 23:38
     * @author: qz
     */ 
    public void backConnection(Connection con){
        pool.add(con);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
