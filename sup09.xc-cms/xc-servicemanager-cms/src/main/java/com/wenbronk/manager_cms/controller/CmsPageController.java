package com.wenbronk.manager_cms.controller;

import com.wenbronk.api.cms.CmsPageControllerApi;
import com.wenbronk.framework.domain.cms.CmsPage;
import com.wenbronk.framework.domain.cms.request.QueryPageRequest;
import com.wenbronk.framework.model.response.CommonCode;
import com.wenbronk.framework.model.response.QueryResponseResult;
import com.wenbronk.framework.model.response.QueryResult;
import com.wenbronk.manager_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 09:41
 * description:
 */
@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    private CmsPageService cmsPageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page,
                                        @PathVariable("size") int size,
                                        QueryPageRequest queryPageRequest) throws Exception {
        return cmsPageService.findList(page, size, queryPageRequest);
    }
}
