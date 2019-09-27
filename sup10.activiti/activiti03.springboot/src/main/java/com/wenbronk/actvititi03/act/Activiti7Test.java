package com.wenbronk.actvititi03.act;

import com.wenbronk.actvititi03.utils.SecurityUtils;
import com.wenbronk.actvititi03.Actitiviti03Application;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-25 09:37
 * description:
 */
@SpringBootTest(classes = Actitiviti03Application.class)
@RunWith(SpringRunner.class)
public class Activiti7Test {

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private TaskRuntime taskRuntime;

    @Autowired
    private SecurityUtils securityUtils;

    /**
     * 开启时自动加载processes下的bpmn文件
     *
     * @throws Exception
     */
    @Test
    public void contextLoad() throws Exception {
        securityUtils.logInAs("salaboy");
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        System.out.println("可用流程定义总数为： " + processDefinitionPage.getTotalItems());
        for (ProcessDefinition processDefinition : processDefinitionPage.getContent()) {
            System.out.println("流程定义：" + processDefinition);
        }
    }

    /**
     * 启动流程实例
     */
    @Test
    public void startProcess() {
        securityUtils.logInAs("ryandawsonuk");
        ProcessInstance aabdafsdfassad = processRuntime.start(ProcessPayloadBuilder.start().withProcessDefinitionKey("aabdafsdfassad").build());
        System.out.println("start process " + aabdafsdfassad.getId());
    }

    /**
     * 查询并完成任务
     */
    @Test
    public void claimProcess() {
        securityUtils.logInAs("erdemedeiros");
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        if (tasks.getTotalItems() > 0) {
            for (Task task : tasks.getContent()) {
                Task claim = taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());
                System.out.println("claim task " + claim.getId());

                // 完成任务
                Task complete = taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());
                System.out.println("complete task " + complete.getId());
            }
        }
        tasks = taskRuntime.tasks(Pageable.of(0, 10));
        System.out.println("finally "  + tasks.getTotalItems());
    }

}
