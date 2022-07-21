package com.itcast.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName ProducerTest
 * @description:
 * @author: isquz
 * @time: 2022/7/13
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 确认模式：
     *      开启模式 ConnectionFactory 中开启publisher-confirms="true"
     *      在rabbitTemplate定义confirmCallBack回调
     *
     */  
    @Test
    public void testConfirm(){
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("confirm() executed...");

                if (b){
                    System.out.println("receive msg succ... " + s);
                }else {
                    System.out.println("receive msg fail... " + s);

                }
            }
        });

        rabbitTemplate.convertAndSend("test_exchange_confirm111", "confirm", "message confirm");
    }

    /**
     * 回退模式：
     *      消息发送给exchange后 exchange路由到Queue失败后才会执行 ReturnCallBack
     *
     *      必须被exchange接收 但没有被 queue接收的 才会触发return
     *
     *      1. 开启回退模式 publisher-returns="true"
     *      2. 设置ReturnCallBack
     *      3.设置Exchange处理消息的模式：
     *          1.如果消息没有路由到Queue 则丢弃消息(默认)
     *          2.如果消息没有路由到queue 返回消息给发送方ReturnCallBack
     */  
    @Test
    public void testReturn(){

        // 设置交换机处理失败的模式：
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("returncallback executed... " );
                System.out.println(message);
                System.out.println(replyCode);
                System.out.println(replyText);
                System.out.println(exchange);
                System.out.println(routingKey);
            }
        });


        rabbitTemplate.convertAndSend("test_exchange_confirm", "confirm22", "message return");
    }

}
