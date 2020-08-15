package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName ${NAME}
 * @description: 添加响应头的自定义信息
 * @author: QZ
 * @time: 2020/8/11 22:33
 */
@WebServlet(name = "HeaderServlet")
public class HeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();

        response.addHeader("name", "zhangsan");
        response.addIntHeader("age", 288);
        response.addDateHeader("birthday", date.getTime());
        response.addHeader("name", "lisi");
        response.setHeader("age", "28");
    }
}
