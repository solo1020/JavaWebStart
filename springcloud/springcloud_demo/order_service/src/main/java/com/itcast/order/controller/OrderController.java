package com.itcast.order.controller;

import com.itcast.order.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName OrderControlle
 * @description:
 * @author: isquz
 * @time: 2022/6/16
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    // 注入RestTemplate
    @Autowired
    private RestTemplate restTemplate;

    /**
     * @description:
     *
     * 通过订单系统 调用商品服务 根据id查询商品信息
     * 需要配置商品对象
     * 需要调用商品服务
     *
     * 可以使用Java urlConnection 调用product_service
     * 也可以使用spring提供的RestTemplate
     *
     * @param: id
     * @return: Product
     * @author: isquz
     * @date: 2022/6/16 23:56
     */  
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id){
        Product product = null;
        // 通过RestTemplate调用商品服务
        product = restTemplate.getForObject("http://127.0.0.1:9001/product/" + id,
                Product.class);
        return product;
    }

}
