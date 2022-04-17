package com.itcast.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName EnableUser2
 * @description:
 * @author: isquz
 * @time: 2022/4/17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(UserConfig.class)
public @interface EnableUser2 {
}
