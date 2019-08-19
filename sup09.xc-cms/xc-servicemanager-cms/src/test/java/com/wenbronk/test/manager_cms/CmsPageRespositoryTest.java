package com.wenbronk.test.manager_cms;

import com.wenbronk.framework.domain.cms.CmsPage;
import com.wenbronk.manager_cms.ManagerCmsApplication;
import com.wenbronk.manager_cms.repository.CmsPageRespository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 10:47
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ManagerCmsApplication.class})
public class CmsPageRespositoryTest {

    @Autowired
    private CmsPageRespository cmsPageRespository;

    @Test
    public void testFinaByPage() {
        PageRequest pageRequest = PageRequest.of(1, 10);
        Page<CmsPage> pages = cmsPageRespository.findAll(pageRequest);
        System.out.println(pages.getTotalElements());

    }

}
