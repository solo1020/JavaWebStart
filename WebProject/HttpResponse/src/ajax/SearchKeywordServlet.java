package ajax;

import adminpage.domain.Product;
import adminpage.service.AdminProductService;
import com.google.gson.Gson;

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
 * @time: 2021/1/18 22:14
 */
@WebServlet(name = "SearchKeywordServlet")
public class SearchKeywordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String word = request.getParameter("word");

        AdminProductService service = new AdminProductService();
        List<Object> productList = null;
        try {
            productList = service.findProductByKeyword(word);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 使用工具进行json转换
        Gson gson = new Gson();
        String json = gson.toJson(productList);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(json);
    }
}
