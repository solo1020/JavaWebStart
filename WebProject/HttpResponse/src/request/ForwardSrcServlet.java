package request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForwardSrcServlet")
public class ForwardSrcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request域对象存储数据
        request.setAttribute("name","tom");

        // 当前servlet 将请求转发给 目标servlet ForwardDstServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("/forwarddst");
        dispatcher.forward(request,response);
    }
}
