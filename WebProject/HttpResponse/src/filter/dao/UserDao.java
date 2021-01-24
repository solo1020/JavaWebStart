package filter.dao;

import filter.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;

/**
 * @ClassName UserDao
 * @description:
 * @author: isquz
 * @time: 2021/1/24 20:02
 */
public class UserDao {

    public User login(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        return runner.query(sql, new BeanHandler<User>(User.class), username,password);
    }
}
