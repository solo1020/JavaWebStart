package login;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import register.User;
import utils.DataSourceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName ${NAME}
 * @description:
 * @author: QZ
 * @time: 2020/8/22 20:38
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
        // 通过user是否为null 判断数据库查询是否正确
        try {
            user = login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null){
            //登录成功跳转首页
            response.sendRedirect(request.getContextPath() + "");
        }else {
            //登录失败也跳转回login.jsp
            // 使用转发可以将登录失败的错误信息添加到 跳转到 servlet中
            request.setAttribute("loginInfo", "用户名或密码错误");
            // 将请求和响应转发给/login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    // 返回User对象
    public User login(String username,String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user_tbl where username=? and password=?";
        User user = runner.query(sql,new BeanHandler<User>(User.class), username, password);
        return user;
    }
}
