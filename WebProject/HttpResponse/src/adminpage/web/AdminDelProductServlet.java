package adminpage.web;

import adminpage.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @ClassName ${NAME}
 * @description: 通过表单提交的商品pid删除数据库中商品
 * @author: QZ
 * @time: 2020/11/6 0:12
 */
@WebServlet(name = "AdminDelProductServlet")
public class AdminDelProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取传递的参数pid
        String pid = request.getParameter("pid");

        // 传递pid到service层
        AdminProductService service = new AdminProductService();
        try {
            service.deleteProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 刷新页面
        response.sendRedirect(request.getContextPath() + "/adminProductList");
    }
}
