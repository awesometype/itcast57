package com.wenbronk.activiti04.company.test;

import com.wenbronk.activiti04.company.dao.DepartmentRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-27 10:53
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRespository departmentRespository;

    @Test
    public void testSave() {

    }

}
