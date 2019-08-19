package com.wenbronk.manager_cms.service;

import com.wenbronk.framework.domain.cms.request.QueryPageRequest;
import com.wenbronk.framework.model.response.QueryResponseResult;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 11:02
 * description:
 */
public interface CmsPageService {

    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) throws Exception;

}
