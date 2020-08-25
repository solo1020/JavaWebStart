package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ${NAME}
 * @description:
 * @author: isquz
 * @time: 2020/8/25 20:52
 */
@WebServlet(name = "CheckLoginImgServlet")
public class CheckLoginImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 获取页面传递的验证码输入
        String checkCode_client = request.getParameter("checkCode");
        // 获取后台生成的验证码源文本信息
        // 因为每次刷新后的验证码都会改变，且不同的客户端是不同的验证码，在生成验证码的时候使用session 存储

        String srcCode = (String) request.getSession().getAttribute("checkcode_session");
        //比对验证码
        if ( !srcCode.equals(checkCode_client) ){
            request.setAttribute("loginInfo", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

            return;
        }

        // 继续验证用户名和密码

        // 登录成功回显
        response.getWriter().write("登录成功!");
    }
}
