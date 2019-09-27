package com.wenbronk.test.rabbitmq.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 09:48
 * description:
 */
public class ConsumerQueue extends BasicConsumer {

    // 声明队列
    private static final String QUEUE = "helloworld";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = getConnection();
        // 获取通道并绑定
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE, true, false, false, null);

        // 监听队列
        channel.basicConsume(QUEUE, true, getCosumer(channel));
    }
}
