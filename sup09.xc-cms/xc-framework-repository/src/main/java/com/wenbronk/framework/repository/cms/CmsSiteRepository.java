package com.wenbronk.framework.repository.cms;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-12 14:38
 * description:
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite, String> {
}
