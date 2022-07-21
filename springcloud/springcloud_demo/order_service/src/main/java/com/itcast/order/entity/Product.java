package com.itcast.order.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;


/**
 * @ClassName Product
 * @description:
 * @author: isquz
 * @time: 2022/6/5
 */
@Data
public class Product {

    private Long id;
    private String productName;
    private Integer status;
    private BigDecimal price;
    private String productDesc;
    private String caption;
    private Integer inventory;

}
