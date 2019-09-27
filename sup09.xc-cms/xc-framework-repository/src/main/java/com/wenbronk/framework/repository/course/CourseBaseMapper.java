package com.wenbronk.framework.repository.course;

import com.github.pagehelper.Page;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.mapstruct.Mapper;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-16 11:01
 * description:
 */
@Mapper
public interface CourseBaseMapper {
    CourseBase findCourseBaseById(String id);
    Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);
}
