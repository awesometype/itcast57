package com.wenbronk.activiti01;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Process;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.junit.Test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-11 14:47
 * description:
 */
public class BpmnConvertTest {

    @Test
    public void testReadXML() throws XMLStreamException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("processes/holiday.bpmn");

        BpmnXMLConverter bpmnXMLConverter = new BpmnXMLConverter();
//        BpmnJsonConverter bpmnJsonConverter = new BpmnJsonConverter();
        XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().createXMLStreamReader(inputStream);

        BpmnModel bpmnModel = bpmnXMLConverter.convertToBpmnModel(xmlStreamReader);
        Process mainProcess = bpmnModel.getMainProcess();
        System.out.println(mainProcess);
    }

}
