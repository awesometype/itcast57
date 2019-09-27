package com.wenbronk.test.rabbitmq.consumer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 10:55
 * description:
 */
public class CosumerTopicSMS extends BasicConsumer {

    //队列名称
//    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    // 交换机名称
    private static final String EXCHANGE_TOPIC_INFORM="exchange_topic_inform";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();

            Channel channel = connection.createChannel();
            // 声明交换机和队列
            channel.exchangeDeclare(EXCHANGE_TOPIC_INFORM, BuiltinExchangeType.DIRECT);
            channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);
            // 绑定交换机和队列， 指定routingkey
            channel.queueBind(QUEUE_INFORM_SMS, EXCHANGE_TOPIC_INFORM, "inform.#.email.#");
            channel.basicConsume(QUEUE_INFORM_SMS, true, getCosumer(channel));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
