package com.wenbronk.activiti01;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Before;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-23 10:14
 * description:
 */
public class BaseTest {

    protected ProcessEngine processEngine;

    @Before
    public void before() {
        processEngine = ProcessEngines.getDefaultProcessEngine();
    }


}
