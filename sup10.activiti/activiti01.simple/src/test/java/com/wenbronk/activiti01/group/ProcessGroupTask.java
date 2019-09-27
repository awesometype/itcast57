package com.wenbronk.activiti01.group;

import com.wenbronk.activiti01.BaseTest;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-23 11:25
 * description:
 */
public class ProcessGroupTask extends BaseTest {

    @Test
    public void findGroupTaskList() {
        String processDefinitionKey = "holiday";
        // 候选人
        String candidateUser = "zhaoliu";

        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskCandidateOrAssigned(candidateUser)
                .list();
        for (Task task : list) {
            System.out.println("流程实例id：" + task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }
    }

    /**
     * 拾取任务
     * 即使任务所有者不是所属人， 也可以拾取， 所以应该先判断
     */
    @Test
    public void clainTask() {
        String taskId = "7502";
//        String userId = "zhaoliu";
        String userId = "zhouqi";

        TaskService taskService = processEngine.getTaskService();
        // 即使任务所有者不是所属人， 也可以拾取， 所以应该先判断
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .taskCandidateUser(userId)
                .singleResult();
        if (task != null) {
            taskService.claim(taskId, userId);
        }
    }

    /**
     * 查询
     */
    @Test
    public void taskQuery() {
        String processDefinitionKey = "holiday";
        String userId = "zhouqi";
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskAssignee(userId)
                .singleResult();
        System.out.println(task.getId());
        System.out.println(task.getAssignee());
    }

    /**
     * 归还组任务， 归还后不属于个人
     */
    @Test
    public void retrunGroupTask() {
        String taskId = "7502";
        String userId = "zhaoliu";

        TaskService taskService = processEngine.getTaskService();
        Task holiday = taskService.createTaskQuery()
                .processDefinitionKey("holiday")
                .taskAssignee(userId)
                .taskId(taskId)
                .singleResult();
        if (holiday != null) {
            taskService.setAssignee(taskId, null);
        }
    }

    /**
     * 任务交接
     */
    @Test
    public void testAssign2CadidateUser() {
        String taskId = "7502";
        // 任务负责人
        String assignUser = "zhouqi";
        // 交接人
        String cadidateUser = "wangwu";

        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .taskAssignee(assignUser)
                .singleResult();

        if (task != null) {
            // 根据候选人和组任务id查询，如果有记录说明该 候选人有资格拾取该 任务
            List<Task> list = taskService.createTaskQuery()
                    .taskId(taskId)
                    .taskCandidateUser(cadidateUser)
                    .list();

            if (list != null && list.size() != 0) {
                taskService.setAssignee(taskId, cadidateUser);
            }
        }
    }

}
