package com.itcast.aop;

/**
 * @ClassName TargetImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/23 21:04
 */
public class TargetImpl implements TargetInterface {
    @Override
    public void save() {
        int i = 1/0;
        System.out.println("save running...");
    }
}
