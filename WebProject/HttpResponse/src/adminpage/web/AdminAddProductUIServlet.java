package adminpage.web;

import adminpage.domain.Category;
import adminpage.service.AdminProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ${NAME}
 * @description: 添加商品页面的商品类别查询下拉选项
 * @author: QZ
 * @time: 2020/11/2 19:33
 */
@WebServlet(name = "AdminAddProductUIServlet")
public class AdminAddProductUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取所有的商品的类别数据
        AdminProductService service = new AdminProductService();
        List<Category> categoryList = null;
        try {
            categoryList = service.findAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("/admin/product/add.jsp").forward(request,response);
    }
}
