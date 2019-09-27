package com.wenbronk.activiti01.variable;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-23 10:08
 * description:
 */
public class ProcessDefinitionTest {

    private ProcessEngine processEngine;

    @Before
    public void before() {
        processEngine = ProcessEngines.getDefaultProcessEngine();
    }

    @Test
    public void testDemploy() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/branch/holiday.bpmn")
                .addClasspathResource("diagram/branch/holiday.png")
                .deploy();
    }
}
