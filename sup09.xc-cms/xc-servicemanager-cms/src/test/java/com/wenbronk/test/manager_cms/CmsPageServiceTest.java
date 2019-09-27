package com.wenbronk.test.manager_cms;

import com.wenbronk.manager_cms.service.CmsPageService;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.wenbronk.manager_cms.ManagerCmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-05 11:36
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ManagerCmsApplication.class})
public class CmsPageServiceTest {

    @Autowired
    private CmsPageService cmsPageService;

//    @Test
//    public void testFindByName() {
//        CmsPage byPageName = cmsPageRepository.findByPageName("4028e581617f945f01617f9dabc40000.html");
//        System.out.println(byPageName);
//    }

    @Test
    public void testFreemarker() {
        String pageHtml = cmsPageService.getPageHtml("5a795ac7dd573c04508f3a56");
        System.out.println(pageHtml);
    }

}
