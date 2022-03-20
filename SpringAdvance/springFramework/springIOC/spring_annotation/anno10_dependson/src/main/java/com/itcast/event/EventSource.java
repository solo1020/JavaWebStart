package com.itcast.event;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @ClassName EventSource
 * @description: 事件源对象
 * @author: isquz
 * @time: 2022/3/14
 */
@Component
@DependsOn("eventZListener")
public class EventSource {
    public EventSource(){
        System.out.println("create EventSource.");
    }
}
