package ajax.service;

import ajax.dao.UserDao;

import java.sql.SQLException;

/**
 * @ClassName UserService
 * @description:
 * @author: QZ
 * @time: 2021/1/15 1:25
 */
public class UserService {
    public boolean checkUsername(String username) throws SQLException {
        UserDao dao = new UserDao();
        Long isExist = dao.checkUsername(username);
        return isExist>0?true:false;
    }
}
