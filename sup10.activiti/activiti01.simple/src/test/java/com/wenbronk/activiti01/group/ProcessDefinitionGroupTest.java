package com.wenbronk.activiti01.group;

import com.google.common.collect.Maps;
import com.wenbronk.activiti01.BaseTest;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-23 11:06
 * description:
 */
public class ProcessDefinitionGroupTest extends BaseTest {

    @Test
    public void testDefinition() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/group/holiday.bpmn")
                .addClasspathResource("diagram/group/holiday.png")
                .deploy();

        System.out.println(deploy.getId());
    }

    /**
     * 第一个的变量必须在启动实例之前设置
     */
    @Test
    public void testStartInstance() {
        String business = UUID.randomUUID().toString();
        Map<String, Object> variables = Maps.newHashMap();
        variables.put("deployee", "zhangsan");

        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey("holiday", business, variables);
    }

    @Test
    public void testGlobalVaraible() {
        Map<String, Object> variables = Maps.newHashMap();
        variables.put("manager", "lisi");
        variables.put("hrs", "wangwu, zhaoliu, zhouqi");

        String taskId = "2506";
        TaskService taskService = processEngine.getTaskService();
        taskService.complete(taskId, variables);
    }

    @Test
    public void testProcessTask() {
        String taskId = "5004";
        TaskService taskService = processEngine.getTaskService();
        taskService.complete(taskId);
    }

}
