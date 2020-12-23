package adminpage.web;

import adminpage.domain.Category;
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
 * @description:
 * @author: QZ
 * @time: 2020/11/7 0:22
 */
@WebServlet(name = "AdminUpdateProductUIServlet")
public class AdminUpdateProductUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取要查询的pid
        String pid = request.getParameter("pid");
        // 传递pid查询商品信息
        AdminProductService service = new AdminProductService();
        Product product = null;
        try {
            product = service.findProductByPid(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 获取所有的商品的类别数据
        List<Category> categoryList = null;
        try {
            categoryList = service.findAllCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("categoryList", categoryList);
//        for(Category c: categoryList){
//            System.out.println("category: " + c.getCname()+ " id: " + c.getCid());
//        }
        request.setAttribute("product", product);
        request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
    }
}
