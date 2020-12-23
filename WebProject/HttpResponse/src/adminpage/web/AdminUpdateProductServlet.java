package adminpage.web;

import adminpage.domain.Product;
import adminpage.service.AdminProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName ${NAME}
 * @description:
 * @author: QZ
 * @time: 2020/11/8 20:06
 */
@WebServlet(name = "AdminUpdateProductServlet")
public class AdminUpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // 获取数据
        Map<String, String[]> parameterMap = request.getParameterMap();

        // 封装数据 使用beanutils
        // beanutils 使用必须保证表单中的name 和对象的属性名一致
        Product product = new Product();
        try {
            BeanUtils.populate(product, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 此时Product对象已经封装完毕
        // 手动设置product其他属性 和中文乱码问题解决
        // 获取商品原来的pid
        // pimage
        product.setPimage("products/1/c_0033.jpg");
        // pdate 上架日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String pdate = format.format(new Date());
        product.setPdate(pdate);
        // pflag 是否下架 0代表未下架
        product.setPflag(0);

        // 传递数据给service 层
        AdminProductService service = new AdminProductService();
        try {
            service.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //此时不能跳转到jsp,因为jsp需要从数据库查询数据，跳转到 AdminProductListServlet
        response.sendRedirect(request.getContextPath() + "/adminProductList");
    }
}
