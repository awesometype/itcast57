package com.wenbronk.manager_cms.controller;

import com.wenbronk.api.cms.CmsConfigControllerApi;
import com.wenbronk.manager_cms.service.CmsConfigService;
import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-09 09:44
 * description:
 */
@RequestMapping("/cms/config")
@RestController
public class CmsConfigController implements CmsConfigControllerApi {

    @Autowired
    private CmsConfigService cmsConfigService;

    @Override
    @GetMapping("/getmodel/{id}")
    public CmsConfig getModel(@PathVariable("id") String id) {
        return cmsConfigService.findById(id);
    }
}
