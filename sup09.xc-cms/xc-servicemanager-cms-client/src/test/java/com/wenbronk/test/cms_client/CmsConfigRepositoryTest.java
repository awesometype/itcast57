package com.wenbronk.test.cms_client;

import com.wenbronk.cms_client.CmsClientApplication;
import com.wenbronk.cms_client.dao.CmsConfigRepository;
import com.xuecheng.framework.domain.cms.CmsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-12 14:16
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CmsClientApplication.class})
public class CmsConfigRepositoryTest {

    @Autowired
    private CmsConfigRepository cmsConfigRepository;

    @Test
    public void testFindAll() {
        for (CmsConfig cmsConfig : cmsConfigRepository.findAll()) {
            System.out.println(cmsConfig);
        }
    }

}
