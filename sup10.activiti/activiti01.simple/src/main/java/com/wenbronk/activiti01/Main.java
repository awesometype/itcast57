package com.wenbronk.activiti01;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.junit.Test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-21 09:51
 * description:
 */
public class Main {

    @Test
    public void testReadXml() throws Exception {
        File file = new File("/Users/wenbronk/code/IdeaProjects/itcast57/sup10.activiti/activiti01.simple/src/main/resources/diagram/holiday.bpmn");
        InputStream inputStream = new FileInputStream(file);//实例化FileInputStream
        // InputStream inputStream = repositoryService.getResourceAsStream( processitionDefinition.getId(),sourceName);
        //创建转换对象
        BpmnXMLConverter converter = new BpmnXMLConverter();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(inputStream);//createXmlStreamReader
        //将xml文件转换成BpmnModel
        BpmnModel bpmnModel = converter.convertToBpmnModel(reader);
        System.out.println();
    }

}
