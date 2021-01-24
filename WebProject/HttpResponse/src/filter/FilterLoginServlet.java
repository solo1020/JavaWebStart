package filter;

import filter.domain.User;
import filter.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
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

        request.setCharacterEncoding("UTF-8");

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

            // 判断用户是否勾选自动登录
            String isAutoLogin = request.getParameter("autologin");
            if(isAutoLogin != null){

                // 对中文进行编码
                String username_encode = URLEncoder.encode(user.getUsername(), "UTF-8");
                String password_encode = URLEncoder.encode(user.getPassword(), "UTF-8");

                Cookie cookie_username = new Cookie("cookie_username", username_encode);
                Cookie cookie_password = new Cookie("cookie_password", password_encode);
                cookie_username.setMaxAge(60*60);
                cookie_password.setMaxAge(60*60);
                // 设置cookie的携带路径
                cookie_username.setPath(request.getContextPath());
                cookie_password.setPath(request.getContextPath());
                response.addCookie(cookie_username);
                response.addCookie(cookie_password);
            }

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
