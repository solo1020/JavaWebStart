package com.itcast;

import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Test
    public void testHelloWorld(){
        rabbitTemplate.convertAndSend("spring_queue", "hello world spring...");
    }

    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("spring_fanout_exchange","", "spring fanout...");
    }

    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend(
                "spring_topic_exchange",
                "heima.hehe.haha",
                "spring topic...to spring_topic_queue_well");
    }
}
