package com.wenbronk.test.rabbitmq.consumer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 10:46
 * description:
 */
public class Producer3Topic extends BasicPorducer {

    //队列名称
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    // 交换机名称
    private static final String EXCHANGE_TOPIC_INFORM="exchange_topic_inform";


    public static void main(String[] args) {
        try {
            Connection connection = getConnection();

            Channel channel = connection.createChannel();
            // 交换机模式变更为 topic
            channel.exchangeDeclare(EXCHANGE_TOPIC_INFORM, BuiltinExchangeType.DIRECT);

            // 队列声明
            channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
            channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);

            // 队列绑定, 多指定一个routingkey
            channel.queueBind(QUEUE_INFORM_EMAIL, EXCHANGE_TOPIC_INFORM, QUEUE_INFORM_EMAIL);
            channel.queueBind(QUEUE_INFORM_SMS, EXCHANGE_TOPIC_INFORM, QUEUE_INFORM_SMS);

            //发送消息
            for (int i = 0; i < 5; i++) {
                String message = "send to user " + i;
                String emailMessage = message + " email";
                String smsMessage = message + " sms";
                // 只发送email
                channel.basicPublish(EXCHANGE_TOPIC_INFORM, "inform.email", null, emailMessage.getBytes("utf-8"));
                // 只发送短信
                channel.basicPublish(EXCHANGE_TOPIC_INFORM, "inform.sms", null, smsMessage.getBytes("utf-8"));
                // 2种都发送
                channel.basicPublish(EXCHANGE_TOPIC_INFORM, "inform.sms.email", null, smsMessage.getBytes("utf-8"));
                System.out.println("send message is " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
