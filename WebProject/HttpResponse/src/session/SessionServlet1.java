package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ClassName SessionServlet1
 * @description:
 * @author: isquz
 * @time: 2020/8/25 7:59
 */
@WebServlet(name = "SessionServlet1")
public class SessionServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 创建属于该客户端会话的私有 session区域
        // 该方法会自动判断该客户端是否在客户端已存在session（通过request里面是否带有JSESSIONID来判断
        // 如果不存在，则新建，如果有，则获取该session
        HttpSession session = request.getSession();

        // 此时 session 对象必不为空,可以直接存储数据
        session.setAttribute("name", "jerry");
        String id = session.getId();

        // 手动存储JSESSIONID到cookie并设置cookie持久化时间
        // 此时第一次访问/session后关闭浏览器再打开，访问/getsession 可以看到之前session设置的属性
        Cookie cookie = new Cookie("JSESSIONID",id);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 10);
        response.addCookie(cookie);

        response.getWriter().write("JSESSIONID: " + id);
    }
}
