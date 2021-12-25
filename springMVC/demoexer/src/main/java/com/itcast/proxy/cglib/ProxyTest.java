package com.itcast.proxy.cglib;

import com.itcast.proxy.jdk.TargetImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyTest
 * @description: 动态代理测试
 * @author: isquz
 * @time: 2021/12/23 22:02
 */
public class ProxyTest {

    public static void main(String[] args) {
//        TargetInterface target = new TargetImpl();
        Target target = new Target();

        Advice advice = new Advice();

        // 基于cglib的动态代理对象
        // 创建增强器
        Enhancer enhancer = new Enhancer();

        // 设置父类
        enhancer.setSuperclass(Target.class);

        // 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 前置增强
                advice.before();

                method.invoke(target, args);
                // 后置增强
                advice.afterReturning();

                return null;
            }
        });

        // 创建代理对象
        Target proxy = (Target) enhancer.create();

        proxy.save();
    }



}
