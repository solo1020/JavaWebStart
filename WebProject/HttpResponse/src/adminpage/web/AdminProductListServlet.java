package adminpage.web;

import adminpage.domain.Product;
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
 * @description: 查询数据库中商品列表
 * @author: QZ
 * @time: 2020/10/31 18:12
 */
@WebServlet(name = "AdminProductListServlet")
public class AdminProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //传递请求到service层
        AdminProductService service = new AdminProductService();
        List<Product> productList = null;
        try {
            productList = service.findAllProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 将productlist数据存储到request域
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("admin/product/list.jsp").forward(request,response);

    }
}
