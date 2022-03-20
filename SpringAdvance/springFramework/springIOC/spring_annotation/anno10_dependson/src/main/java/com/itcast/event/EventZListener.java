package com.itcast.event;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @ClassName EventListener
 * @description: 监听器
 * @author: isquz
 * @time: 2022/3/14
 */
@Component
public class EventZListener {

    public EventZListener(){
        System.out.println("create EventListener");
    }
}
