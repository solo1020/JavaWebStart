package com.itcast.proxy.jdk;

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
        TargetImpl target = new TargetImpl();

        Advice advice = new Advice();

        // 返回代理对象 替换target
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                // 目标对象类加载器
                target.getClass().getClassLoader(),
                // 目标对象相同的接口字节码数组
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    // 调用代理对象的任何方法都是通过invoke实现
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 前置增强
                        advice.before();
                        Object invoke = method.invoke(target, args);

                        // 后置增强
                        advice.afterReturning();

                        return invoke;
                    }
                }
        );

        // 调用代理对象方法
        proxy.save();
    }



}
