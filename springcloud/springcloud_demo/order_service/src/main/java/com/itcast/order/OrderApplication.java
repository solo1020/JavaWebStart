package com.itcast.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ProductApplication
 * @description:
 * @author: isquz
 * @time: 2022/6/15
 */

@SpringBootApplication
@EntityScan("com.itcast.order.entity")
public class OrderApplication {

    /**
     *
     * 使用spring提供的RestTemplate发送http请求到商品服务
     * 创建RestTemplate对象交给容器管理
     * 在使用时 调用方法getXX 完成操作
     *
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
