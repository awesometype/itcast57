package com.wenbronk.framework.repository.cms;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-09 17:10
 * description:
 */
@Repository
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String> {
}
