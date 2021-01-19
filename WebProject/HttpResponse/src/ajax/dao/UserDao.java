package ajax.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;

/**
 * @ClassName UserDao
 * @description:
 * @author: QZ
 * @time: 2021/1/15 1:27
 */
public class UserDao {


    public Long checkUsername(String username) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user where username=?";
        Long query = (Long) runner.query(sql, new ScalarHandler(), username);
        return query;

    }
}
