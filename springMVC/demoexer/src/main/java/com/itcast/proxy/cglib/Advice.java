package com.itcast.proxy.cglib;

/**
 * @ClassName Advice
 * @description:
 * @author: isquz
 * @time: 2021/12/23 21:18
 */
public class Advice {

    public void before(){
        System.out.println("before...");
    }

    public void afterReturning(){
        System.out.println("after...");
    }

}
