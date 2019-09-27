package com.wenbronk.manager_cms.controller;

import com.wenbronk.api.cms.CmsPageControllerApi;
import com.wenbronk.framework.model.response.CommonCode;
import com.wenbronk.framework.model.response.ResponseResult;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.wenbronk.framework.model.response.QueryResponseResult;
import com.wenbronk.manager_cms.service.CmsPageService;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size,
                                        QueryPageRequest queryPageRequest) throws Exception {
        return cmsPageService.findList(page, size, queryPageRequest);
    }

    @Override
    @PostMapping("/add")
    public CmsPageResult add(@RequestBody CmsPage cmsPage) {
        return cmsPageService.add(cmsPage);
    }

    @Override
    @GetMapping("/get/{id}")
    public CmsPageResult findById(@PathVariable("id") String id) {
        return new CmsPageResult(CommonCode.SUCCESS, cmsPageService.findById(id));
    }

    @Override
    @PutMapping("/edit/{id}")
    public CmsPageResult edit(@PathVariable("id") String id, @RequestBody CmsPage cmsPage) {
        return cmsPageService.update(id, cmsPage);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult delete(@PathVariable("id") String id) {
        return cmsPageService.delete(id);
    }

    @Override
    @GetMapping("/generateHtml/{id}")
    public ResponseResult post(@PathVariable("id") String pageId) throws IOException {
        return cmsPageService.postPage(pageId);
    }

}
