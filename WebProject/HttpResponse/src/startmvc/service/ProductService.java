package startmvc.service;

import startmvc.dao.ProductDao;
import startmvc.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ProductService
 * @description:
 * @author: isquz
 * @time: 2020/10/9 21:56
 */
public class ProductService {

    public List<Product> findAllProduct() throws SQLException {
        // 传递请求到DAO　层
        ProductDao dao = new ProductDao();
        List<Product> productList = dao.findAllProduct();
        return productList;
    }
}
