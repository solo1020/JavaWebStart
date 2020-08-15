package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyFirstServlet
 * @description:
 * @author: QZ
 * @time: 2020/8/1 21:04
 */
public class MyFirstServlet implements Servlet {

    /**
     * @description: 向客户端提供响应的方法
     * @param servletRequest
     * @param servletResponse
     * @author: QZ
     * @date: 2020/8/1 21:05
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.getWriter().println("This is my first servlet!");
        response.getWriter().println("<!DOCTYPE html>\n");
        response.getWriter().println("<html>\n");
        response.getWriter().println("<br/><h1 style='color:red'>nihao</h1>\n");
        response.getWriter().println("</html>\n");


    }


    /**
     * @description:
     * @param servletConfig
     * @author: QZ
     * @date: 2020/8/1 21:06
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }


    /**
     * @description:
     * @param:
     * @return: javax.servlet.ServletConfig
     * @author: QZ
     * @date: 2020/8/1 21:18
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
