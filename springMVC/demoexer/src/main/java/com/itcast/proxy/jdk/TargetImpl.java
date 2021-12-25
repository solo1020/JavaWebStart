package com.itcast.proxy.jdk;

/**
 * @ClassName TargetImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/23 21:04
 */
public class TargetImpl implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
