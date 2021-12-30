package com.itcast.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @ClassName MyAspect
 * @description: 切面类
 * @author: isquz
 * @time: 2021/12/25 23:18
 */

public class MyAspect {

    public void before(){
        System.out.println("before advice...");
    }

    public void afterReturning(){
        System.out.println("afterReturning advice...");
    }

    // ProceedingJoinPoint 即连接点
    // 是否可以用来追踪项目执行路径 或添加日志 或 统计方法耗时
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("around advice [before-around]...");
        // 切点方法
        Object proceed = point.proceed();
//        System.out.println(point.getThis());
        System.out.println(point.getSignature());
        System.out.println("around advice [after-around]...");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("afterThrowing advice...");
    }

    public void after(){
        System.out.println("after advice...");
    }

}
