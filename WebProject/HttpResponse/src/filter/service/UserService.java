package filter.service;

import filter.dao.UserDao;
import filter.domain.User;

import java.sql.SQLException;

/**
 * @ClassName UserService
 * @description:
 * @author: isquz
 * @time: 2021/1/24 20:01
 */
public class UserService {

    public User login(String username, String password) throws SQLException {
        UserDao dao = new UserDao();
        return dao.login(username,password);

    }
}
