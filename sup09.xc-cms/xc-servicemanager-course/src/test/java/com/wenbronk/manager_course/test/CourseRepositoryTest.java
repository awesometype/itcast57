package com.wenbronk.manager_course.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wenbronk.framework.repository.course.CourseBaseMapper;
import com.wenbronk.framework.repository.course.CourseBaseRepository;
import com.wenbronk.framework.repository.course.TeachplanMapper;
import com.wenbronk.manager_course.CourseApplication;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-16 10:48
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CourseApplication.class})
public class CourseRepositoryTest {

    @Autowired
    private CourseBaseRepository courseBaseRepository;

    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Autowired
    private TeachplanMapper teachplanMapper;

    @Test
    public void test() {
        List<CourseBase> all = courseBaseRepository.findAll();
        for (CourseBase courseBase : all) {
            System.out.println(courseBase);
        }

        CourseBase courseBaseById = courseBaseMapper.findCourseBaseById("297e7c7c62b8aa9d0162b8ab13910000");
        System.out.println(courseBaseById);
    }

    @Test
    public void test2() {
        TeachplanNode teachplanNode = teachplanMapper.selectList("297e7c7c62b888f00162b8a965510001");
        System.out.println(teachplanNode);
    }

    @Test
    public void testPageHelper() {
        PageHelper.startPage(1, 10);//查询第一页，每页显示10条记录
        CourseListRequest courseListRequest = new CourseListRequest();
        Page<CourseInfo> courseListPage = courseBaseMapper.findCourseListPage(courseListRequest);
        List<CourseInfo> result = courseListPage.getResult();
        System.out.println(courseListPage);
    }

}
