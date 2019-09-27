package com.wenbronk.manager_cms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-12 10:00
 * description:
 */
@ConfigurationProperties(prefix = "xc.mq")
@Data
public class MQProperties {

    private String queue;
    private String routingKey;

}
