package com.wenbronk.api.course;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-17 07:55
 * description:
 */
@Api(value = "课程分类管理",description = "课程分类管理",tags = {"课程分类管理"})
public interface CategoryControllerApi {
    @ApiOperation("查询分类")
    public CategoryNode findList();
}
