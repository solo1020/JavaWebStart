package listener.attribute;

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
 * @author: isquz
 * @time: 2021/1/20 0:37
 */
@WebServlet(name = "TestServletContextAttributeListenerServlet")
public class TestServletContextAttributeListenerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        context.setAttribute("name","tom");

        context.setAttribute("name","lucy");

        context.removeAttribute("name");
    }
}
