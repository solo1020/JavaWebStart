package com.itcast.product.service;

import com.itcast.product.entity.Product;

/**
 * @ClassName ProductService
 * @description:
 * @author: isquz
 * @time: 2022/6/13
 */
public interface ProductService {
    
    /**
     * 根据id查询
     */
    Product findById(Long id);

    void save(Product product);

    void update(Product product);

    void delete(Long id);

}
