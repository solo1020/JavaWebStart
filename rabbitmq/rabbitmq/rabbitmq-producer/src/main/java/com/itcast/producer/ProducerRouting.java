package com.itcast.producer;

import com.rabbitmq.client.BuiltinExchangeType;
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
public class ProducerRouting {

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


        // 创建交换机
        /**
         * String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments
         * type：交换机类型
         *     DIRECT("direct"), 定向
         *     FANOUT("fanout"), 扇形 广播
         *     TOPIC("topic"),   通配符方式
         *     HEADERS("headers"); 参数匹配
         *
         * durable:是否持久化
         * internal：内部使用 一般false
         * argument：参数
         */

        String exchangeName = "test_direct";
        channel.exchangeDeclare(
                exchangeName,
                BuiltinExchangeType.DIRECT,
                true,
                false,
                false,
                null
        );

        // 创建队列
        String queue1Name = "test_direct_queue1";
        String queue2Name = "test_direct_queue2";
        channel.queueDeclare(queue1Name, true, false, false,null);
        channel.queueDeclare(queue2Name, true, false, false,null);


        // 绑定队列和交换机
        /**
         * String queue, String exchange, String routingKey
         * routingKey:路由键 绑定规则
         *      如果交换机类型为fanout广播 routingkey 设置为空字符串
         */
        // 队列1 绑定 error
        channel.queueBind(queue1Name, exchangeName, "error");
        // 队列2 绑定 info error warning 三种
        channel.queueBind(queue2Name, exchangeName, "info");
        channel.queueBind(queue2Name, exchangeName, "error");
        channel.queueBind(queue2Name, exchangeName, "warning");


        // 发送消息
        String body = "日志信息：张三调用了delete方法出错...日志级别：error...";
        channel.basicPublish(exchangeName, "warning", null, body.getBytes());

        // 释放资源
        channel.close();
        connection.close();





    }
}
