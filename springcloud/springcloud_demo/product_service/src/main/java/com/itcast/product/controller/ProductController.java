package com.itcast.product.controller;

import com.itcast.product.entity.Product;
import com.itcast.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ProductController
 * @description:
 * @author: isquz
 * @time: 2022/6/15
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        Product product = productService.findById(id);
        return product;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody Product product){
        productService.save(product);
        return "save success.";
    }

}
