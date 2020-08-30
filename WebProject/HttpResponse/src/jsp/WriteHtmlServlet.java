package jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName WriteHtmlServlet
 * @description: 手动使用servlet写整个html页面，很繁琐
 * @author: isquz
 * @time: 2020/8/26 8:25
 */
@WebServlet(name = "WriteHtmlServlet")
public class WriteHtmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>");
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<meta charset='UTF-8'>");
        writer.write("<title>Insert title here</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>这个页面很繁琐</h1>");
        writer.write("</body>");
        writer.write("</html>");

    }
}
