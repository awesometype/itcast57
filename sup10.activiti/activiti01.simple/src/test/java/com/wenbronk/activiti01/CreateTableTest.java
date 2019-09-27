package com.wenbronk.activiti01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-21 09:56
 * description:
 */

public class CreateTableTest {

    public static void main(String[] args) {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
//        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml", "processEngineConfiguration01");
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

}
