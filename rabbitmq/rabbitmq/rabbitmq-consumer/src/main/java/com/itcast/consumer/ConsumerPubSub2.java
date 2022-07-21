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
public class ConsumerPubSub2 {

    private static String TAG = "[consumer 2] --- ";

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


        String queue1Name = "test_fanout_queue1";
        String queue2Name = "test_fanout_queue2";

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
                System.out.println(TAG + "body: " + new String(body));
                System.out.println("将日志信息保存数据库...");

            }
        };

        channel.basicConsume(queue2Name, true, consumer);

        // 一直监听 不需要关闭资源
        // channel.close(); connection.close();
    }
}
