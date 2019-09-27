package com.wenbronk.activiti04.company.config;

import com.wenbronk.activiti04.common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-26 09:38
 * description:
 */
@Configuration
public class CompanyConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

}
