package com.wenbronk.test.rabbitmq.consumer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 10:46
 * description:
 */
public class Producer3Routing extends BasicPorducer {

    //队列名称
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    // 交换机名称
    private static final String EXCHANGE_ROUTING_INFORM="exchange_routing_inform";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();

            Channel channel = connection.createChannel();
            // 交换机模式变更为 direct
            channel.exchangeDeclare(EXCHANGE_ROUTING_INFORM, BuiltinExchangeType.DIRECT);

            // 队列声明
            channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
            channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);

            // 队列绑定, 多指定一个routingkey
            channel.queueBind(QUEUE_INFORM_EMAIL, EXCHANGE_ROUTING_INFORM, "routingemail");
            channel.queueBind(QUEUE_INFORM_SMS, EXCHANGE_ROUTING_INFORM, "routingsms");

            //发送消息
            for (int i = 0; i < 5; i++) {
                String message = "send to user " + i;
                String emailMessage = message + " email";
                String smsMessage = message + " sms";

                channel.basicPublish(EXCHANGE_ROUTING_INFORM, "routingemail", null, emailMessage.getBytes("utf-8"));
                channel.basicPublish(EXCHANGE_ROUTING_INFORM, "routingsms", null, smsMessage.getBytes("utf-8"));
                System.out.println("send message is " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
