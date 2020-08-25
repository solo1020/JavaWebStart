package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName GetSessionServlet
 * @description:
 * @author: isquz
 * @time: 2020/8/25 8:29
 */
@WebServlet(name = "GetSessionServlet")
public class GetSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从session中获取存储的数据
        HttpSession session = request.getSession();

        String name = (String) session.getAttribute("name");
        response.getWriter().write(name);
    }
}
