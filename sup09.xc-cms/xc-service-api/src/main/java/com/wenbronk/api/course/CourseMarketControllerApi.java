package com.wenbronk.api.course;

import com.wenbronk.framework.model.response.ResponseResult;
import com.xuecheng.framework.domain.course.CourseMarket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-17 07:59
 * description:
 */
@Api(value = "课程营销相关")
public interface CourseMarketControllerApi {

    @ApiOperation("获取课程营销信息")
    public CourseMarket getCourseMarketById(String courseId);

    @ApiOperation("更新课程营销信息")
    public ResponseResult updateCourseMarket(String id, CourseMarket courseMarket);
}
