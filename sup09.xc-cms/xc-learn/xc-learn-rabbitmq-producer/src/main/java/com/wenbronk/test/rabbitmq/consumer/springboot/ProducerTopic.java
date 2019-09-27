package com.wenbronk.test.rabbitmq.consumer.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 11:28
 * description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTopic {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendTopics() {
        for (int i = 0; i < 5; i++) {
            String message = "send message to user " + i;
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_TOPICS_INFORM, "inform.sms.email", message);
            System.out.println("send message is " + message);
        }
    }

}
