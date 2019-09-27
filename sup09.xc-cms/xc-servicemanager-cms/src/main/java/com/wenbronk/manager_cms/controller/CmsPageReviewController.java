package com.wenbronk.manager_cms.controller;

import com.wenbronk.framework.web.BaseController;
import com.wenbronk.manager_cms.service.CmsPageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-10 11:24
 * description: 页面预览
 */
@Controller
public class CmsPageReviewController extends BaseController {

    @Autowired
    private CmsPageService cmsPageService;

    @RequestMapping(value="/cms/preview/{pageId}",method = RequestMethod.GET)
    public void pageReview(@PathVariable("id") String id) throws IOException {
        String pageHtml = cmsPageService.getPageHtml(id);
        if (StringUtils.isNotEmpty(pageHtml)) {
            response.getOutputStream().write(pageHtml.getBytes("utf-8"));
        }
    }

}
