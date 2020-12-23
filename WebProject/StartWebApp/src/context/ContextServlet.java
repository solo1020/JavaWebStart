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
 * @time: 2020/8/8 22:14
 */
//@WebServlet(name = "ContextServlet")
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // ServletContext
        ServletContext servletContext = getServletContext();
        String initParamter = servletContext.getInitParameter("driver");
        System.out.println(initParamter);

        String pathA = servletContext.getRealPath("a.txt");
        System.out.println(pathA);

        String pathB = servletContext.getRealPath("/WEB-INF/b.txt");
        System.out.println(pathB);

        String pathC = servletContext.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(pathC);

        // class下面的 c.txt可以通过类加载器方式获取
        String pathC2 = ContextServlet.class.getClassLoader().getResource("c.txt").getPath();
        System.out.println(pathC2);

        // 获取不到工程根目录下的 d.txt


        // 使用域对象 ServletContext 进行 存取数据 在当前servlet存，ContextServlet2读取
        servletContext.setAttribute("name", "zhangsan");

    }
}
