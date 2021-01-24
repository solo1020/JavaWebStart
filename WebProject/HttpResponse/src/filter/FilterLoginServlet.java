package filter;

import filter.domain.User;
import filter.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName ${NAME}
 * @description:
 * @author: isquz
 * @time: 2021/1/23 1:58
 */
@WebServlet(name = "FilterLoginServlet")
public class FilterLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService service = new UserService();
        User user = null;
        try {
            user = service.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(user!=null){

            // 一般将User对象信息存到session中
            session.setAttribute("user",user);

            //  登录成功 地址栏需要改变 重定向至首页
            response.sendRedirect(request.getContextPath());
        }else {
            request.setAttribute("loginInfo","用户名和密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
