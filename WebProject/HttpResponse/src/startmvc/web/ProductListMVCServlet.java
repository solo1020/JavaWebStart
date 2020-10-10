package startmvc.web;

import startmvc.domain.Product;
import startmvc.service.ProductService;

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
 * @description: MVC模式重写商品列表页面
 * @author: isquz
 * @time: 2020/10/9 21:52
 */
@WebServlet(name = "ProductListMVCServlet")
public class ProductListMVCServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 传递请到service层
        ProductService service = new ProductService();
        List<Product> productList = null;
        try {
            productList = service.findAllProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 数据转发给jsp进行展示
        request.setAttribute("productList", productList);

        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}
