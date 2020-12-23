package adminpage.dao;

import adminpage.domain.Category;
import adminpage.domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName AdminProductDao
 * @description:
 * @author: QZ
 * @time: 2020/11/1 20:40
 */
public class AdminProductDao {
    public List<Product> findAllProduct() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product_jsp";
        List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));
        return list;
    }

    public List<Category> findAllCategory() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from category_admin";
        List<Category> list = runner.query(sql, new BeanListHandler<Category>(Category.class));
        return list;
    }

    // 添加商品到数据库
    public void addProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into product_jsp values(?,?,?,?,?,?,?,?,?,?)";
        runner.update(sql,
                product.getPid(),
                product.getPname(),
                product.getMarket_price(),
                product.getShop_price(),
                product.getPimage(),
                product.getPdate(),
                product.getIs_hot(),
                product.getPdesc(),
                product.getPflag(),
                product.getCid());

//        session.save();       hibernate 存储到数据库
    }

    public void deleteProductByPid(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from product_jsp where pid=?";
        runner.update(sql, pid);
    }

    public Product findProductByPid(String pid) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product_jsp where pid=?";
        Product product = runner.query(sql, new BeanHandler<Product>(Product.class), pid );
        return product;
    }

    public void updateProduct(Product product) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update product_jsp " +
                "set pname=?, " +
                "market_price=?, " +
                "shop_price=?," +
                "pimage=?," +
                "pdate=?, " +
                "is_hot=?, " +
                "pdesc=?, " +
                "pflag=?, " +
                "cid=? where pid=?";
        runner.update(sql,
                product.getPname(),
                product.getMarket_price(),
                product.getShop_price(),
                product.getPimage(),
                product.getPdate(),
                product.getIs_hot(),
                product.getPdesc(),
                product.getPflag(),
                product.getCid(),
                product.getPid() );
    }
}
