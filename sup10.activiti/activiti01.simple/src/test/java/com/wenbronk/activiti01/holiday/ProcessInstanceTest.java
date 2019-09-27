package com.wenbronk.activiti01.holiday;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-22 09:57
 * description: 流程实例
 */
public class ProcessInstanceTest {

    private ProcessEngine processEngine;

    @Before
    public void before() {
        processEngine = ProcessEngines.getDefaultProcessEngine();
    }

    /**
     * 启动一个流程实例
     */
    @Test
    public void testProcessInstanceStart() {
        String processDefinitionKey = "holiday";
        String businessKey = "uuid001";
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey(processDefinitionKey, businessKey);

        System.out.println(processInstance.getDeploymentId());
        System.out.println("流程实例id" + processInstance.getId());
        System.out.println("当前活动id" + processInstance.getActivityId());
    }

    /**
     * 查询流程实例
     */
    @Test
    public void testProcessInstanceQuery() {
        String processDefinitionKey = "holiday";
        RuntimeService runtimeService = processEngine.getRuntimeService();

        List<ProcessInstance> processInstanceList = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .list();

        for (ProcessInstance processInstance : processInstanceList) {
            System.out.println(processInstance.getId());
            System.out.println("流程实例id: " + processInstance.getProcessInstanceId());
            System.out.println("流程定义id: " + processInstance.getProcessDefinitionId());
            System.out.println("执行完成 " + processInstance.isEnded());
            System.out.println("流程挂起 " + processInstance.isSuspended());
        }
    }

    /**
     * 挂起流程定义下所有流程实例
     */
    @Test
    public void testProcessInstanceSuspendAll() {
        // 获取流程定义
        String processDefinitionKey = "holiday";
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(processDefinitionKey)
                .singleResult();

        // 暂停与开启
        if (processDefinition.isSuspended()) {
            repositoryService.suspendProcessDefinitionByKey(processDefinitionKey, true, new Date());
            System.out.println("流程实例开始");
        } else {
            repositoryService.suspendProcessDefinitionByKey(processDefinitionKey, true, new Date());
            System.out.println("流程实例挂起");
        }
    }

    /**
     * 单个流程挂起
     */
    @Test
    public void testProcessInstanceSuspendSingle() {
        String processInstanceId = "2501";

        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult();

        if (processInstance.isSuspended()) {
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程激活");
        } else {
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程暂停");
        }
    }

}
