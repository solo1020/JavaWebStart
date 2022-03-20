package com.itcast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName District
 * @description: 用于定义区域的注解
 * @author: isquz
 * @time: 2022/2/17 23:21
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface District {
    /**
     * @description: 用于指定区域名称
     * @param:
     * @return: java.lang.String
     * @author: isquz
     * @date: 2022/2/17 23:25
     */
    String value();
}
