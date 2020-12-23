package adminpage.service;

import adminpage.dao.AdminProductDao;
import adminpage.domain.Category;
import adminpage.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName AdminProductService
 * @description:
 * @author: QZ
 * @time: 2020/11/1 20:21
 */
public class AdminProductService {
    public List<Product> findAllProduct() throws SQLException {
        // 没有复杂业务 直接传递到dao层
        AdminProductDao dao = new AdminProductDao();
        return dao.findAllProduct();
    }

    // 获取所有商品的类别
    public List<Category> findAllCategory() throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        return dao.findAllCategory();
    }

    //添加商品
    public void addProduct(Product product) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        dao.addProduct(product);
    }

    // 根据pid删除商品
    public void deleteProductByPid(String pid) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        dao.deleteProductByPid(pid);
    }

    public Product findProductByPid(String pid) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        return dao.findProductByPid(pid);
    }

    // 更新商品
    public void updateProduct(Product product) throws SQLException {
        AdminProductDao dao = new AdminProductDao();
        dao.updateProduct(product);
    }
}
