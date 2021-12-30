package com.itcast.aopAnnotation;

import org.springframework.stereotype.Component;

/**
 * @ClassName TargetImpl
 * @description:
 * @author: isquz
 * @time: 2021/12/23 21:04
 */

// 使用spring容器管理该类的对象创建
@Component("target")
public class TargetImpl implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
