package com.wenbronk.manager_cms.service;

import com.wenbronk.framework.repository.cms.CmsConfigRepository;
import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-09 09:41
 * description:
 */
@Service
public class CmsConfigService {

    @Autowired
    private CmsConfigRepository cmsConfigRepository;

    public CmsConfig findById(String id) {
        Optional<CmsConfig> optionalCmsConfig = cmsConfigRepository.findById(id);
        return optionalCmsConfig.orElse(null);
    }
}
