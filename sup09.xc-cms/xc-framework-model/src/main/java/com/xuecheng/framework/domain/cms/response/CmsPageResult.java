package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.wenbronk.framework.model.response.ResponseResult;
import com.wenbronk.framework.model.response.ResultCode;
import lombok.Data;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-05 19:45
 * description:
 */
@Data
public class CmsPageResult extends ResponseResult {
    CmsPage cmsPage;
    public CmsPageResult(ResultCode resultCode,CmsPage cmsPage) {
        super(resultCode);
        this.cmsPage = cmsPage;
    }
}
