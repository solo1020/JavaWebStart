package ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ${NAME}
 * @description: jquery 的ajax 请求响应servlet
 * @author: isquz
 * @time: 2020/12/20 13:58
 */
@WebServlet(name = "jqueryAjaxServlet")
public class JqueryAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name + " " + age);

        int i = 1 / 0;  // 演示ajax 方法请求失败的error回调

        // jquery ajax 解析返回数据时指定为json会报错，实际返回的是字符串
        // java代码只能返回一个json 格式的字符串

//        response.getWriter().write("success...");
        response.setContentType("text/html;charset=UTF-8");// 解决响应数据中文乱码
        response.getWriter().write("{\"name\":\"汤姆\",\"age\":21}");
    }
}
