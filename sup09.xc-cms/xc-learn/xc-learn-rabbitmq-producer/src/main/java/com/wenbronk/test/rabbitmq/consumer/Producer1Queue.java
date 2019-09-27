package com.wenbronk.test.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 09:31
 * description:
 */
public class Producer1Queue extends BasicPorducer {

    private static final String QUEUE = "helloworld";

    public static void main(String[] args) {
        Connection connection = null;
        Channel channel = null;

        try {
            connection = getConnection();

            // 创建Exchange通道， 每个连接可以有多个通道， 每个通道代表一个会话任务
            channel = connection.createChannel();

            /** 声明队列
             * * param1:队列名称
             * * param2:是否持久化
             * * param3:队列是否独占此连接
             * * param4:队列不再使用时是否自动删除此队列
             * * param5:队列参数
             */
            channel.queueDeclare(QUEUE, true, false, false, null);

            String message = "hello world " + System.currentTimeMillis();

            /**
             * 发送， 这里没有指定交换机，消息将发送给默认交换机，每个队列也会绑定那个默认的交换机，但是不能显示绑定或解除绑定
             * * param1：Exchange的名称，如果没有指定，则使用Default Exchange
             * * param2:routingKey,消息的路由Key，是用于Exchange（交换机）将消息转发到指定的消息队列
             * * param3:消息包含的属性
             * * param4：消息体
             */
            channel.basicPublish("", QUEUE, null, message.getBytes("utf-8"));
            System.out.println("Send message is : " + message);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
        }
    }


}
