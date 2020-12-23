package context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ${NAME}
 * @description:
 * @author: QZ
 * @time: 2020/8/9 0:15
 */
@WebServlet(name = "ContextServlet2")
public class ContextServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 从 ContextServlet域中读取数据
        ServletContext context = getServletContext();
        Object name = context.getAttribute("name");
        System.out.println(name);

    }
}
