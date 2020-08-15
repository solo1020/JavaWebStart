package login;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
 * @time: 2020/8/6 23:22
 */
//@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        int count = 0;
        getServletContext().setAttribute("count", count);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post ...");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username + "password: " + password);
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        System.out.println(sql);
        User user = null;
        try {
            user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            System.out.println("query sql error!");
            e.printStackTrace();
        }

        if(user != null){
            System.out.println("query ok!");

            ServletContext context = getServletContext();
            Integer count = (Integer) context.getAttribute("count");
            count++;
            context.setAttribute("count", count);

            response.getWriter().write(user.toString() + "--- you are the " + count + " visitor");
        }else {
            response.getWriter().write("sorry your username or password is wrong");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
