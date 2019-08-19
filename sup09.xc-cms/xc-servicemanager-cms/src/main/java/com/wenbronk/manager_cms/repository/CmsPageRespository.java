package com.wenbronk.manager_cms.repository;

import com.wenbronk.framework.domain.cms.CmsPage;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 10:46
 * description:
 */
@Repository
public interface CmsPageRespository extends MongoRepository<CmsPage, String> {
    CmsPage findByPageName(String pageName);
    CmsPage findByPageNameAndPageType(String pageName, String pageType);

    //根据站点和页面类型查询记录数
    int countBySiteIdAndPageType(String siteId,String pageType);

    //根据站点和页面类型分页查询
//    Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);

}
