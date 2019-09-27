package com.wenbronk.activiti01.variable.local;

import com.google.common.collect.Maps;
import com.wenbronk.activiti01.BaseTest;
import org.activiti.engine.TaskService;
import org.junit.Test;

import java.util.Map;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-23 10:39
 * description: 设置local变量测试
 */
public class ProcessVaraibleLocalTest extends BaseTest {

    /**
     * local变量因为节点后会失效， 所以只能在任务进行时设置
     */
    @Test
    public void test() {
        String taskId = "7502";
        String variableName = "hr";
        String variableValue = "vini";

        TaskService taskService = processEngine.getTaskService();
        taskService.setVariableLocal(taskId, variableName, variableValue);
        taskService.complete(taskId);
    }

    @Test
    public void testMulti() {
        String taskId = "7502";

        Map<String, Object> variables = Maps.newHashMap();
        variables.put("manager", "lisi");
        variables.put("president", "wangwu");
        variables.put("hr", "zhaoliu");

        TaskService taskService = processEngine.getTaskService();
        taskService.setVariablesLocal(taskId, variables);
    }

}
