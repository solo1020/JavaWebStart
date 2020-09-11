package jsp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

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
 * @description: 须先执行 jsp_product.sql 创建product_jsp 数据表并插入数据
 * @author: QZ
 * @time: 2020/9/11 20:54
 */
@WebServlet(name = "ProductListServlet")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product_jsp";
        List<Product> productList = null;
        try {
             productList = qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //将数据存储到request域
        request.setAttribute("productList", productList);
        // 将request 域数据转发到 /product_list.jsp
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}
