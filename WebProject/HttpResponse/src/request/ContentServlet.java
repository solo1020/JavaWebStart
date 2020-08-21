package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "ContentServlet")
public class ContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获得单个表单值
        String username = request.getParameter("username");
        System.out.println("username: " + username);
        String password = request.getParameter("password");
        System.out.println("password: " + password);

        // 获取多个表单的值
        String[] hobbys = request.getParameterValues("hobby");
        for(String hobby: hobbys){
            System.out.println("hobby: " + hobby);
        }
        // 获取所有请求参数的名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }

        // 获取所有参数 到 一个Map<String,String[]>
        Map<String,String[]> paramterMap = request.getParameterMap();
        for(Map.Entry<String,String[]> entry:paramterMap.entrySet()){
            System.out.println("parameter key: " + entry.getKey());
            for(String s : entry.getValue()){
                System.out.println("parameter " + entry.getKey() + " value: " + s);
            }
            System.out.println("------------------------");
        }
    }
}
