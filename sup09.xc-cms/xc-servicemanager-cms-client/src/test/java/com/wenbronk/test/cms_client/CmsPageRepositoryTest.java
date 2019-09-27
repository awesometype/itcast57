package com.wenbronk.test.cms_client;

import com.wenbronk.cms_client.CmsClientApplication;
import com.wenbronk.framework.repository.cms.CmsPageRepository;
import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-12 11:39
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CmsClientApplication.class})
public class CmsPageRepositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Test
    public void testFind() {
        List<CmsPage> all = cmsPageRepository.findAll();
        all.forEach(System.out::println);
    }

}
