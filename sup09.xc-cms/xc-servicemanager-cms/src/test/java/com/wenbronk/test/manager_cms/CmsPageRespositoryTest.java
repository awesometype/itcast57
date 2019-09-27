package com.wenbronk.test.manager_cms;

import com.wenbronk.framework.repository.cms.CmsPageRepository;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.wenbronk.manager_cms.ManagerCmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 10:47
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ManagerCmsApplication.class})
public class CmsPageRespositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testFinaByPage() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<CmsPage> pages = cmsPageRepository.findAll(pageRequest);
        System.out.println(pages.getTotalElements());

    }

    @Test
    public void testFindAll() {
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        cmsPage.setTemplateId("5a925be7b00ffc4b3c1578b5");
        cmsPage.setPageAliase("详情");

        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        // 包含
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
//        ExampleMatcher.GenericPropertyMatchers.startsWith()
//        ExampleMatcher.GenericPropertyMatchers.endsWith()
//        ExampleMatcher.GenericPropertyMatchers.caseSensitive()

        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<CmsPage> page = cmsPageRepository.findAll(example, pageRequest);
        System.out.println(page.getTotalElements());

    }

    @Test
    public void testFindByTemplate() {
        Query query = new Query(Criteria.where("siteId").is("5a751fab6abb5044e0d19ea1"));
        CmsPage one = mongoTemplate.findOne(query, CmsPage.class);
        System.out.println(one);
    }

    @Test
    public void testFindOne() {
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        Example<CmsPage> example = Example.of(cmsPage);
        Optional<CmsPage> one = cmsPageRepository.findOne(example);
        one.ifPresent(cmsPage1 -> System.out.println(cmsPage1));
    }


}
