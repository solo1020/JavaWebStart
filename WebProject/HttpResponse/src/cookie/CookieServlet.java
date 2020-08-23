package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CookieServlet
 * @description:
 * @author: isquz
 * @time: 2020/8/23 17:05
 */
@WebServlet(name = "cookie.CookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建cookie对象
        Cookie cookie = new Cookie("name","zhangsan");

        // 为cookie设置持久化时间
        cookie.setMaxAge(60 * 10);

        // 设置cookie 携带路径
        cookie.setPath("/cookie");  // 访问该路径时才携带该cookie

        // 将cookie中存储的信息发送到客户端--响应头
        response.addCookie(cookie);

    }
}
