package com.wenbronk.cms_client.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-12 10:11
 * description:
 */
@Configuration
@EnableConfigurationProperties(MQProperties.class)
public class RabbitMQAutoConfiguration {
    // 队列名字
    public static final String QUEUE_CMS_POSTAGE = "queue_cms_postage";
    // 交换机的名字
    public static final String EX_ROUTING_CMS_POSTAGE = "ex_routing_cms_postage";

    /**
     * 声明交换机 direct 类型
     */
    @Bean(EX_ROUTING_CMS_POSTAGE)
    public Exchange EX_ROUTING_CMS_POSTAGE() {
        return ExchangeBuilder
                .directExchange(EX_ROUTING_CMS_POSTAGE)
                .durable(true)
                .build();
    }

    /**
     * 声明队列
     */
    @Bean(QUEUE_CMS_POSTAGE)
    public Queue QUEUE_CMS_POSTAGE(MQProperties mqProperties) {
        return new Queue(mqProperties.getQueue());
    }

    /**
     * 绑定队列到交换机
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(EX_ROUTING_CMS_POSTAGE) Exchange exchange,
                                            @Qualifier(QUEUE_CMS_POSTAGE) Queue queue, MQProperties mqProperties) {
        return BindingBuilder.bind(queue).to(exchange).with(mqProperties.getRoutingKey()).noargs();
    }

}
