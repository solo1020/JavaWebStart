package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LineServlet")
public class LineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取请求方式
        String method = request.getMethod();
        System.out.println("request method: " + method);

        // 2.获取请求资源的相关内容
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("request URI: " + requestURI);
        System.out.println("request URL: " + requestURL);

        //获取web应用名称
        String contextPath = request.getContextPath();
        System.out.println("web 应用: " + contextPath);

        // 获取请求参数
        String queryString = request.getQueryString();
        System.out.println("request params: " + queryString);
    }
}
