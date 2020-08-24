package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName GetCookieServlet
 * @description:
 * @author: isquz
 * @time: 2020/8/23 21:05
 */
@WebServlet(name = "GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取客户端携带的cookie数据
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies){
                String cookieName = cookie.getName();
                if (cookieName.equals("name")){
                    String cookieValue = cookie.getValue();
                    System.out.println("cookie value: " + cookieValue);
                }
            }
        }

    }
}
