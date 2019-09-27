//package com.wenbronk.activiti01;
//
//import org.activiti.api.process.model.ProcessInstance;
//import org.activiti.bpmn.BpmnAutoLayout;
//import org.activiti.bpmn.model.*;
//import org.activiti.bpmn.model.Process;
//import org.activiti.engine.repository.Deployment;
//import org.activiti.engine.runtime.ProcessInstance;
//import org.activiti.engine.task.Task;
//import org.activiti.engine.test.ActivitiRule;
//import org.apache.commons.io.FileUtils;
//import org.junit.Assert;
//import org.junit.Rule;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.InputStream;
//import java.util.List;
//
///**
// * @Author wenbronk <meng.wen@kangtaitong.cn>
// * @Date 2019-09-11 15:11
// * description:
// */
//public class BpmnTest2 {
//
//    @Rule
//    public ActivitiRule activitiRule = new ActivitiRule();
//
//    @Test
//    public void testDynamicDeploy() throws Exception {
//
//// 1. Build up the model from scratch
//        BpmnModel model = new BpmnModel();
//        Process process = new Process();
//        model.addProcess(process);
//        process.setId("my-process");
//        // 创建flow元素， 所有的事件， 任务都被认为是flow
//        process.addFlowElement(createStartEvent());
//        process.addFlowElement(createUserTask("task1", "First task", "fred"));
//        process.addFlowElement(createUserTask("task2", "Second task", "john"));
//        process.addFlowElement(createEndEvent());
//        process.addFlowElement(createSequenceFlow("start", "task1"));
//        process.addFlowElement(createSequenceFlow("task1", "task2"));
//        process.addFlowElement(createSequenceFlow("task2", "end"));
//
//
//        // 2. 流程图自动布局
//        new BpmnAutoLayout(model).execute();
//
//        // 3. bpmn model 部署到引擎
//        Deployment deployment = activitiRule.getRepositoryService().createDeployment()
//                .addBpmnModel("dynamic-model.bpmn", model).name("Dynamic process deployment")
//                .deploy();
//
//        // 4. 启动引擎
//        ProcessInstance processInstance = activitiRule.getRuntimeService()
//                .startProcessInstanceByKey("my-process");
//
//        // 5. 检查正常启动
//        List<Task> tasks = activitiRule.getTaskService().createTaskQuery()
//                .processInstanceId(processInstance.getId())
//                .list();
//        Assert.assertEquals(1, tasks.size());
//        Assert.assertEquals("First task", tasks.get(0).getName());
//        Assert.assertEquals("fred", tasks.get(0).getAssignee());
//
//        // 6. 导出流程图
//        InputStream processDiagram = activitiRule.getRepositoryService()
//                .getProcessDiagram(processInstance.getProcessDefinitionId());
//        FileUtils.copyInputStreamToFile(processDiagram, new File("target/diagram.png"));
//
//        // 7. 导出bpmn文件到本地文件系统
//        InputStream processBpmn = activitiRule.getRepositoryService()
//                .getResourceAsStream(deployment.getId(), "dynamic-model.bpmn");
//
//        FileUtils.copyInputStreamToFile(processBpmn, new File("target/process.bpmn20.xml"));
//    }
//
//
//    protected UserTask createUserTask(String id, String name, String assignee) {
//        UserTask userTask = new UserTask();
//        userTask.setName(name);
//        userTask.setId(id);
//        userTask.setAssignee(assignee);
//        return userTask;
//
//    }
//
//
//    protected SequenceFlow createSequenceFlow(String from, String to) {
//        SequenceFlow flow = new SequenceFlow();
//        flow.setSourceRef(from);
//        flow.setTargetRef(to);
//        return flow;
//    }
//
//
//    protected StartEvent createStartEvent() {
//        StartEvent startEvent = new StartEvent();
//        startEvent.setId("start");
//        return startEvent;
//
//    }
//
//
//    protected EndEvent createEndEvent() {
//        EndEvent endEvent = new EndEvent();
//        endEvent.setId("end");
//        return endEvent;
//    }
//
//
//}
