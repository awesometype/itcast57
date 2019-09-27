package com.wenbronk.api.cms;

import com.wenbronk.framework.model.response.ResponseResult;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.wenbronk.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 09:23
 * description:
 */
@Api(value="cms页面管理接口",description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {

    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value = "页码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录数",required=true,paramType="path",dataType="int")
    })
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) throws Exception;

    @ApiOperation("添加页面")
    CmsPageResult add(CmsPage cmsPage);

    @ApiOperation("根据id查询页面")
    CmsPageResult findById(String id);

    @ApiOperation("修改页面")
    CmsPageResult edit(String id, CmsPage cmsPage);

    @ApiOperation("根据id删除页面")
    ResponseResult delete(String id);

    @ApiOperation("静态页面发布")
    ResponseResult post(String pageId) throws IOException;


}
