package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ${NAME}
 * @description:
 * @author: isquz
 * @time: 2020/8/24 6:47
 */
@WebServlet(name = "LastAccessTimeServlet")
public class LastAccessTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = format.format(date);
        // 创建cookie 存储最新访问时间
        Cookie cookie = new Cookie("lastAccessTime", currentTime);
        cookie.setMaxAge(60 * 10 * 500);
        response.addCookie(cookie);

        // 获取客户端携带的cookie
        String lastAccessTime = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie coo : cookies){
                if("lastAccessTime".equals(coo.getName())){
                    lastAccessTime = coo.getValue();
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        if (lastAccessTime == null){
            response.getWriter().write("您是第一次访问本站");
        }else {
            response.getWriter().write("您上次访问时间是： " + lastAccessTime);
        }
    }
}
