package com.wenbronk.api.cms;

import com.xuecheng.framework.domain.cms.CmsConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-09 09:36
 * description:
 */
@Api(value = "cms配置管理接口", description = "cms配置管理接口，提供数据模型的管理、查询接口")
public interface CmsConfigControllerApi {

    @ApiOperation(value = "根据id查询cms的配置信息")
    CmsConfig getModel(String id);

}
