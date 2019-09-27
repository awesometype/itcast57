package com.wenbronk.activiti01.variable;

import com.google.common.collect.Maps;
import com.wenbronk.activiti01.BaseTest;
import org.activiti.engine.TaskService;
import org.junit.Test;

import java.awt.*;
import java.util.Map;
import java.util.UUID;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-23 10:30
 * description:
 */
public class ProcessVaraibleTaskTest extends BaseTest {

    @Test
    public void testSingleVaraible() {
        String taskId = "2512";
        TaskService taskService = processEngine.getTaskService();

        Map<String, Object> variables = Maps.newHashMap();
        variables.put("employee", "zhangsan");

        taskService.complete(taskId, variables);
    }

    @Test
    public void testMultiVaraible() {
        // 设置变量
        Map<String, Object> variables = Maps.newHashMap();
        variables.put("manager", "lisi");
        variables.put("president", "wangwu");
        variables.put("hr", "zhaoliu");

        // 设置实体类进流程变量， 必须实现序列化皆苦
        HolidayInfo holidayInfo = new HolidayInfo();
        holidayInfo.setId(UUID.randomUUID().toString());
        holidayInfo.setName("default");
        holidayInfo.setNum(3);

        variables.put("holiday", holidayInfo);

        TaskService taskService = processEngine.getTaskService();
        taskService.complete("5002", variables);
    }


}
