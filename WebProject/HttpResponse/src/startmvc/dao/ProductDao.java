package startmvc.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import startmvc.domain.Product;
import startmvc.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ProductDao
 * @description:
 * @author: isquz
 * @time: 2020/10/9 21:59
 */
public class ProductDao {

    public List<Product> findAllProduct() throws SQLException {
        // 操作数据库
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product_jsp";
        List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));
        return productList;
    }
}
