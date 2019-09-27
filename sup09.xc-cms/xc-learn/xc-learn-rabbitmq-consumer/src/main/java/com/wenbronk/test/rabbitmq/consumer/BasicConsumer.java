package com.wenbronk.test.rabbitmq.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 10:44
 * description:
 */
public class BasicConsumer {

    protected static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("vhost_rabbitmq");

        return factory.newConnection();
    }


    protected static Consumer getCosumer(Channel channel) {
        return new DefaultConsumer(channel) {
            /**
             * * @param consumerTag 消费者的标签，在channel.basicConsume()去指定
             * * @param envelope 消息包的内容，可从中获取消息id，消息routingkey，交换机，消息和重传标志 (收到消息失败后是否需要重新发送)
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // 交换机
                String exchange = envelope.getExchange();
                // 路由key
                String routingKey = envelope.getRoutingKey();
                // 消息id
                long deliveryTag = envelope.getDeliveryTag();
                // 消息体
                String string = new String(body, "utf-8");
                System.out.println(string);
            }
        };
    }

}
