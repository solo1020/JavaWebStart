package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName QuickStartServlet
 * @description:
 * @author: QZ
 * @time: 2020/8/3 22:42
 */
public class QuickStartServlet implements Servlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("QuickStartServlet running...");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet name: " + servletConfig.getServletName());

        String initParam = servletConfig.getInitParameter("url");
        System.out.println("servlet config : " + initParam);

        ServletContext servletContext = servletConfig.getServletContext();

        System.out.println("init running...");
    }

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
        System.out.println("destroy running...");
    }
}
