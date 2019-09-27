package com.wenbronk.activiti01.holiday;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-21 11:00
 * description:
 */
public class ProcessDefinitionTest {

    /**
     * 单文件上传
     */
    @Test
    public void testSingleFile() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn")
                .addClasspathResource("diagram/holiday.png")
                .name("请假申请单")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getCategory());
        System.out.println(deployment.getName());
    }

    /**
     * zip上传
     */
    @Test
    public void testzipFile() {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("diagram/holiday.zip");
        ZipInputStream zipInputStream = new ZipInputStream(stream);

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("zip请假申请单")
                .deploy();

        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
        System.out.println(deploy.getCategory());
    }

    /**
     * 定义查询
     */
    @Test
    public void testQueryDesign() {
        String processDefinitinKey = "myProcess_1";
//        String processDefinitinKey = "holiday";

        // 获取processengine 和 repositoryService
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 获取流程定义查询
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.processDefinitionKey(processDefinitinKey)
                .orderByProcessDefinitionVersion()
                .desc().list();

        for (ProcessDefinition processDefinition : processDefinitionList) {
            System.out.println("------------------------");
            System.out.println("流程部署id：" + processDefinition.getDeploymentId());
            System.out.println("流程定义id：" + processDefinition.getId());
            System.out.println("流程定义名称：" + processDefinition.getName());
            System.out.println("流程定义key：" + processDefinition.getKey());
            System.out.println("流程定义版本：" + processDefinition.getVersion());
        }
    }

    /**
     * 流程定义删除
     */
    @Test
    public void testProcessDefinitionDel() {
        String demployId = "1";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 设置为true为级联删除的方式
        repositoryService.deleteDeployment(demployId, true);
    }

    /**
     * 流程定义资源查询
     */
    @Test
    public void testProcessDefinitionResourceQuery() throws IOException {
        String processDefitionId = "holiday:1:5004";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionId(processDefitionId)
                .singleResult();

//        System.out.println(processDefinition.getId());

        // 获取bpmn
        String bpmnName = processDefinition.getResourceName();
        System.out.println("bpmn name is " + bpmnName);
        // 获取png
        String pngName = processDefinition.getDiagramResourceName();
        System.out.println("png name is " + pngName);

        // 获取文件流
        InputStream bpmStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), bpmnName);
        InputStream pngStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), pngName);

        // copy to file, use commons io
        System.out.println(bpmStream.available());
        System.out.println(pngStream.available());
    }

    @Test
    public void testProcessDefinitionHistory() {
        String instanceId = "";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        HistoryService historyService = processEngine.getHistoryService();

        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(instanceId)
                .list();

        for (HistoricActivityInstance historicActivityInstance : list) {
            System.out.println(historicActivityInstance.getActivityId());
            System.out.println(historicActivityInstance.getActivityName());
            System.out.println(historicActivityInstance.getProcessDefinitionId());
            System.out.println(historicActivityInstance.getProcessInstanceId());
        }

    }

}
