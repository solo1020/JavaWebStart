package com.itcast.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ProducerHelloWorld
 * @description:发送消息
 * @author: isquz
 * @time: 2022/7/4
 */
public class ProducerHelloWorld {

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

        /*
         * String exchange, String routingKey, BasicProperties props, byte[] body
         *
         * exchange：交换机
         * routingkey：路由名称
         * props: 配置信息
         * body：发送到消息数据
         *
         */
        String body = "hello rabbitmq";

        // 发送消息
        channel.basicPublish("", "hello world", null, body.getBytes());

        // 释放资源
        channel.close();
        connection.close();



    }
}
