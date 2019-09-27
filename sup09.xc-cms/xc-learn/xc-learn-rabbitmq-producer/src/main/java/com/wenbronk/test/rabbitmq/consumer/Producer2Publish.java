package com.wenbronk.test.rabbitmq.consumer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 10:12
 * description: 发布订阅模式
 */
public class Producer2Publish extends BasicPorducer {

    // 队列
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";

    // 交换机
    private static final String EXCHANGE_FANOUT_INFORM="exchange_fanout_inform";

    public static void main(String[] args) {

        try (Connection connection = getConnection()) {
            // 创建通道， 每个通道代表一个会话
            Channel channel = connection.createChannel();
            // 声明交换机
            channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.FANOUT);

            // 声明队列
            channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
            channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);

            // 绑定交换机和队列
            channel.queueBind(QUEUE_INFORM_EMAIL, EXCHANGE_FANOUT_INFORM, "");
            channel.queueBind(QUEUE_INFORM_SMS, EXCHANGE_FANOUT_INFORM, "");

            // 发送消息
            for (int i = 0; i < 5; i++) {
                String message = "inform to user " + i;
                // 发送消息
                channel.basicPublish(EXCHANGE_FANOUT_INFORM, "", null, message.getBytes("utf-8"));
                System.out.println("send message is " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
