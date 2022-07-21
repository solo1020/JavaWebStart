package com.itcast.product.dao;

import com.itcast.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName ProductDao
 * @description:
 * @author: isquz
 * @time: 2022/6/11
 */
public interface ProductDao extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

}
