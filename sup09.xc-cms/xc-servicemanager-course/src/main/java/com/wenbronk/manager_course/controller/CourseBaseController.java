package com.wenbronk.manager_course.controller;

import com.wenbronk.api.course.CourseBaseControllerApi;
import com.wenbronk.framework.model.response.QueryResponseResult;
import com.wenbronk.framework.model.response.ResponseResult;
import com.wenbronk.manager_course.service.CourseBaseService;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-16 11:31
 * description:
 */
@RestController
@RequestMapping(path = "/course")
public class CourseBaseController implements CourseBaseControllerApi {

    @Autowired
    private CourseBaseService courseBaseService;

    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public TeachplanNode findTeachplanList(@PathVariable("courseId") String courseId) {
        return courseBaseService.findTeachplanList(courseId);
    }

    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplan(Teachplan teachplan) {
        return courseBaseService.addTeachplan(teachplan);
    }

    @Override
    public QueryResponseResult<CourseInfo> findCourseList(int page, int size, CourseListRequest courseListRequest) {
        return null;
    }

    @Override
    public CourseBase getCourseBaseById(String courseId) throws RuntimeException {
        return null;
    }

    @Override
    public ResponseResult updateCourseBase(String id, CourseBase courseBase) {
        return null;
    }
}
