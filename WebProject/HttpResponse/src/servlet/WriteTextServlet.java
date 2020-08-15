package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ${NAME}
 * @description:
 * @author: QZ
 * @time: 2020/8/14 23:03
 */
@WebServlet(name = "WriteTextServlet")
public class WriteTextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        writer.write("hello response!!");
        // 中文会显示？，需设置response查询的编码表
        response.setCharacterEncoding("UTF-8");

        // 此时还需要告诉客户端使用哪个表进行解码
//        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("中国");
    }
}
