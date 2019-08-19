package com.wenbronk.manager_cms.service.impl;

import com.wenbronk.framework.domain.cms.CmsPage;
import com.wenbronk.framework.domain.cms.request.QueryPageRequest;
import com.wenbronk.framework.model.response.*;
import com.wenbronk.manager_cms.repository.CmsPageRespository;
import com.wenbronk.manager_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 11:03
 * description:
 */
@Service
@Transactional
public class CmsPageServiceImpl implements CmsPageService {

    @Autowired
    private CmsPageRespository cmsPageRespository;

    @Override
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) throws Exception {
        if (queryPageRequest == null) {
            queryPageRequest = new QueryPageRequest();
        }
        if (page <= 0) {
            page = 1;
        }
        // 符合人们习惯
        page --;

        if (size <= 0) {
            size = 10;
        }

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<CmsPage> pages = cmsPageRespository.findAll(pageRequest);

        QueryResult<CmsPage> queryResult = new QueryResult<>();
        queryResult.setList(pages.getContent());
        queryResult.setTotal(pages.getTotalElements());


        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }
}
