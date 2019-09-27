package com.wenbronk.activiti01.holiday;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-23 09:03
 * description:
 */
public class ProcessTaskTest {

    private ProcessEngine processEngine;

    @Before
    public void before() {
        processEngine = ProcessEngines.getDefaultProcessEngine();
    }

    @Test
    public void processTaskQueryTest() {
        String leader = "zhangsan";
        String bigLeader = "lisi";
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee("zhangsan")
                .list();

        for (Task task : list) {
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }

    /**
     * 执行任务
     */
    @Test
    public void ProcessTaskStartTest() {
        String taskId = "47502";
        TaskService taskService = processEngine.getTaskService();
        taskService.complete(taskId);
    }

}
