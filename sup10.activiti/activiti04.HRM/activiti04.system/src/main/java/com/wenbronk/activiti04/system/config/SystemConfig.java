package com.wenbronk.activiti04.system.config;

import com.wenbronk.activiti04.common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 09:22
 * description:
 */
@Configuration
public class SystemConfig {
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

}
