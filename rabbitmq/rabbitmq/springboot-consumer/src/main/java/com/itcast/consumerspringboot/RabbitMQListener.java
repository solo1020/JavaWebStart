package com.itcast.consumerspringboot;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName RabbitMQListener
 * @description:
 * @author: isquz
 * @time: 2022/7/18
 */

@Component
public class RabbitMQListener {

    // 队列queue 与 生产者中配置的一致
    @RabbitListener(queues = "boot_queue")
    public void listenerQueue(Message message){
//        System.out.println(message);
        System.out.println(new String(message.getBody()));
    }
}
