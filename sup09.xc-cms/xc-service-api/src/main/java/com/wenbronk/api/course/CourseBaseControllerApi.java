package com.wenbronk.api.course;

import com.wenbronk.framework.model.response.QueryResponseResult;
import com.wenbronk.framework.model.response.ResponseResult;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-16 11:27
 * description:
 */
@Api("课程查询相关的api定义")
public interface CourseBaseControllerApi {

    @ApiOperation("课程计划查询")
    TeachplanNode findTeachplanList(String courseId);

    @ApiOperation("添加课程计划")
    ResponseResult addTeachplan(Teachplan teachplan);

    @ApiOperation("查询我的课程列表")
    public QueryResponseResult<CourseInfo> findCourseList(
            int page,
            int size,
            CourseListRequest courseListRequest
    );

    @ApiOperation("获取课程基础信息")
    public CourseBase getCourseBaseById(String courseId) throws RuntimeException;

    @ApiOperation("更新课程基础信息")
    public ResponseResult updateCourseBase(String id,CourseBase courseBase);
}
