package com.itcast.aopAnnotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyAspect
 * @description: 切面类
 * @author: isquz
 * @time: 2021/12/25 23:18
 */

// 使用spring容器管理该类的对象创建
@Component("myAspect")
@Aspect // 标注是切面
public class MyAspect {

    // 定义切点表达式
    @Pointcut(value = "execution(* com.itcast.aopAnnotation.*.*(..) )")
    public void pointCutDef(){}

    // 配置前置增强
    @Before(value = "pointCutDef()")
    public void before(){
        System.out.println("before advice...");
    }

    @AfterReturning(value = "pointCutDef()")
    public void afterReturning(){
        System.out.println("afterReturning advice...");
    }

    // ProceedingJoinPoint 即连接点
    // 是否可以用来追踪项目执行路径 或添加日志 或 统计方法耗时
    @Around(value = "execution(* com.itcast.aopAnnotation.*.*(..) )")
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

    @After(value = "MyAspect.pointCutDef()")
    public void after(){
        System.out.println("after advice...");
    }

}
