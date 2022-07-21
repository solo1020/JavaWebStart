package com.itcast.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @ClassName ProductApplication
 * @description:
 * @author: isquz
 * @time: 2022/6/15
 */

@SpringBootApplication
@EntityScan("com.itcast.product.entity")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
