package com.itcast.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ConsumerHelloWorld
 * @description:
 * @author: isquz
 * @time: 2022/7/5
 */
public class ConsumerHelloWorld {

    public static void main(String[] args) throws IOException, TimeoutException {
// 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        // 设置参数
        factory.setHost("192.168.33.224");
        factory.setPort(5672);
        factory.setVirtualHost("/itcast");   // 默认虚拟机是/
        factory.setUsername("itcast");
        factory.setPassword("itcast");


        // 创建连接
        Connection connection = factory.newConnection();

        // 创建Channel
        Channel channel = connection.createChannel();

        // 创建队列Queue
        /**
         * String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
         *
         *  queue: 队列名称
         *  durable：是否持久化 当mq重启后 还在
         *  exclusive：
         *      是否独占 只能有一个消费者监听该队列
         *      当connection关闭时 是否删除队列
         *
         *  autoDelete：是否自动删除 当没有consumer时自动删除
         *  arguments：参数
         *
         */

        // 如果没有该名称的队列 则会创建该名称的队列
        channel.queueDeclare(
                "hello world",
                true,
                false,
                false,
                null
        );

        /**
         * String queue, boolean autoAck, Consumer callback
         * queue:队列
         * autoAck: 是否自动确认
         * callback：回调对象
         *
         */
        Consumer consumer = new DefaultConsumer(channel){
            // 回调方法 当收到消息时 会自动执行该方法
            /**
             * @description:
             * @param: consumerTag 标识
             * @param: envelope 获取交换机信息 路由key信息等
             * @param: properties 配置信息
             * @param: body 消息数据体
             * @return: void
             *
             * @author: isquz
             * @date: 2022/7/5 23:25
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("ConsumerTag: " + consumerTag);
                System.out.println("Exchange: " + envelope.getExchange());
                System.out.println("RoutingKey: " + envelope.getRoutingKey());
                System.out.println("properties: " + properties);
                System.out.println("body: " + new String(body));

            }
        };

        channel.basicConsume("hello world", true, consumer);

        // 一直监听 不需要关闭资源
        // channel.close(); connection.close();
    }
}
