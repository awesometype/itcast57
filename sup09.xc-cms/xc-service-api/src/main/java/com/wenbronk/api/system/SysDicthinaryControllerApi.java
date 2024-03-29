package com.wenbronk.api.system;

import com.xuecheng.framework.domain.system.SysDictionary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-17 07:56
 * description:
 */
@Api(value = "数据字典接口",description = "提供数据字典接口的管理、查询功能")
public interface SysDicthinaryControllerApi {
    //数据字典
    @ApiOperation(value="数据字典查询接口")
    public SysDictionary getByType(String type);
}
