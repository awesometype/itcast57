package com.wenbronk.test.rabbitmq.consumer.springboot;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 11:32
 * description:
 */
@Component
public class ConsumerTopic {

    /**
     * 监听email
     */
    @RabbitListener(queues = RabbitMQConfig.QUEUE_INFORM_EMAIL)
    public void receiveEmail(String msg, Message message, Channel channel) {
        System.out.println("email is " + msg);
    }

    /**
     * 监听sms
     */
    @RabbitListener(queues = RabbitMQConfig.QUEUE_INFORM_SMS)
    public void receiveSms(String msg, Message message, Channel channel) {
        System.out.println("sms is " + msg);
    }
}
