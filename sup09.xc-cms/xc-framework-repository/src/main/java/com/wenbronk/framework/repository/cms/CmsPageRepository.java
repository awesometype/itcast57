package com.wenbronk.framework.repository.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 10:46
 * description:
 */
@Repository
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {
//    CmsPage findByPageName(String pageName);
//    CmsPage findByPageNameAndPageType(String pageName, String pageType);
//
//    /**
//     * 根据站点和页面类型查询记录数
//     */
//    int countBySiteIdAndPageType(String siteId,String pageType);

    /**
     * 根据站点和页面类型分页查询
     */
//    Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);

    /**
     * 检测页面唯一性
     * 根据页面名称、站点id、页面访问路径查询
     */
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName, String siteId, String pageWebPath);

}
