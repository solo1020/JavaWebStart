package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ${NAME}
 * @description: 重定向的初始访问servlet
 * @author: QZ
 * @time: 2020/8/12 9:22
 */
@WebServlet(name = "beforeRedirectServlet")
public class BeforeRedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().write("hello haohao...");
        response.setStatus(302);
//        response.setHeader("Location", "/directDst");

        response.sendRedirect("directDst");
    }
}
