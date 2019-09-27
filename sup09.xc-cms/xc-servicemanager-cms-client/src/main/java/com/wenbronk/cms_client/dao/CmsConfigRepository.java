package com.wenbronk.cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-09 09:41
 * description:
 */
@Repository
public interface CmsConfigRepository extends MongoRepository<CmsConfig, String> {
}
