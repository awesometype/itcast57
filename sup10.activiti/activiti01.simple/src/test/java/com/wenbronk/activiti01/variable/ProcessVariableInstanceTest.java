package com.wenbronk.activiti01.variable;

import com.google.common.collect.Maps;
import com.wenbronk.activiti01.BaseTest;
import org.activiti.engine.RuntimeService;
import org.junit.Test;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-23 10:00
 * description: 流程变量测试
 */
public class ProcessVariableInstanceTest extends BaseTest {

    private Map<String, Object> variables;
    private HolidayInfo holidayInfo = new HolidayInfo();

    public ProcessVariableInstanceTest() {
        // 设置变量
        variables = Maps.newHashMap();
        variables.put("employee", "zhangsan");
        variables.put("manager", "lisi");
        variables.put("president", "wangwu");
        variables.put("hr", "zhaoliu");

        // 设置实体类进流程变量， 必须实现序列化皆苦
        holidayInfo.setId(UUID.randomUUID().toString());
        holidayInfo.setName("default");
        holidayInfo.setNum(3);

        variables.put("holiday", holidayInfo);
    }

    @Test
    public void testGlobalVariable() {
        String processInstanceKey = "holiday";

        // 启动实例时设置流程变量
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey(processInstanceKey, holidayInfo.getId(), variables);
    }
}


class HolidayInfo implements Serializable {
    private String id;
    private String name;
    private Integer num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
