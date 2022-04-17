package com.itcast.springbootcondition.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @ClassName ConditionOnClass
 * @description:
 * @author: isquz
 * @time: 2022/4/16
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ClassCondition.class)
public @interface ConditionOnClass {
    String[] value();
}
