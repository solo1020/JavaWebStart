package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RefererServlet")
public class RefererServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 对新闻来源进行判断
        String header = request.getHeader("referer");
        // 因为是本地测试 多加了一条判断  endWith()
        if(header != null && header.startsWith("http://localhost") && header.endsWith("form.html")){
            // startWith用来判断referer是否是本网站打开的链接
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("中国已经100块金牌");
        }else {
            response.getWriter().write("盗链可耻。。。");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 跳转来源页
            response.setStatus(302);
            response.setHeader("Location", "/form.html");
        }
    }
}
