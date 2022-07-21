package com.itcast.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @ClassName SpringQueueListener
 * @description:
 * @author: isquz
 * @time: 2022/7/14
 */
public class SpringQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(new String( message.getBody() ) );
    }
}
