package com.wenbronk.test.rabbitmq.consumer;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 10:45
 * description:
 */
public class BasicPorducer {

    protected static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);

        factory.setUsername("admin");
        factory.setPassword("admin");
        // rabbitmq默认的虚拟机明为'/'， 虚拟机相当于一个独立的mq服务器
        factory.setVirtualHost("vhost_rabbitmq");

        // 创建rabbitmq 的 tcp的连接
        return factory.newConnection();
    }

}
