package com.wenbronk.manager_cms.service;

import com.wenbronk.framework.model.response.ResponseResult;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.wenbronk.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;

import java.io.IOException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 11:02
 * description:
 */
public interface CmsPageService {

    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) throws Exception;

    CmsPageResult add(CmsPage cmsPage);

    CmsPage findById(String id);

    CmsPageResult update(String id, CmsPage cmsPage);

    ResponseResult delete(String id);

    String getPageHtml(String pageId);

    ResponseResult postPage(String pageId) throws IOException;
}
