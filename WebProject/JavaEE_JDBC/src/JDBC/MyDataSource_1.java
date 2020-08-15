package JDBC;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @ClassName MyDataSource_1
 * @Description TODO
 * @Author QZ
 * @Date 2020/7/22 0:10
 * @Version 1.0
 **/
public class MyDataSource_1 implements DataSource {
    private static LinkedList<Connection> pool = new LinkedList<>();

    static{
        for (int i = 0; i < 5; i++) {
            Connection con = JDBCUtils_V3.getConnection();

            // 放入连接池的Connection对象是 封装过的MyConnection
            MyConnection myConnection = new MyConnection(con, pool);
            pool.add(myConnection);
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        Connection con = null;
        if(pool.size() == 0){
            for (int i = 0; i < 5; i++) {
                con = JDBCUtils_V3.getConnection();
                // 放入连接池的Connection对象是 封装过的MyConnection
                MyConnection myConnection = new MyConnection(con, pool);
                pool.add(myConnection);
            }
        }
        // 从连接池中获取一个链接对象Connection

        // 连接池还是这个连接池，只不过池中每个Connection对象穿了一件外套
        // 一件已经改造过close() 方法的外套
        // 此时 这个连接池中实际上全是MyConnection的对象
        // 每个MyConnection 对象包含有原来的Connection
        // remove获取到的 可以多态 赋值给Connection接口的引用
        con = pool.remove(0);
        return con;
    }



    /**
     * 已经不需要这个归还Connection对象的方法了
     * 因为直接con.close()就可以
     * 而这个con对象 实际上在连接池中就是MyConnection对象
     * 所以调用close()方法，走的是已经改造过的close()方法
     */

    /**
     * description: 将连接对象返回到连接池
     * @param
     * @return: void
     * @date: 2020/7/20 23:38
     * @author: qz
     */
//    public void backConnection(Connection con){
//        pool.add(con);
//    }

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
