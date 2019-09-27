package com.wenbronk.test.rabbitmq.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 10:30
 * description:
 */
public class CosumerPublishEmail extends BasicConsumer {

    // 队列名称
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
//    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";

    // 交换机
    private static final String EXCHANGE_FANOUT_INFORM="exchange_fanout_inform";

    public static void main(String[] args) {
        // 创建连接
        try {
            Connection connection = getConnection();
            // 创建通道
            Channel channel = connection.createChannel();
            // 声明交换机
            channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.FANOUT);
            // 声明队列并绑定交换机
            channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
            channel.queueBind(QUEUE_INFORM_EMAIL, EXCHANGE_FANOUT_INFORM, "");
            // 消费
            channel.basicConsume(QUEUE_INFORM_EMAIL, true, getCosumer(channel));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
