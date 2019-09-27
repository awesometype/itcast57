package com.wenbronk.manager_course.service;

import com.wenbronk.framework.exception.ExceptionCast;
import com.wenbronk.framework.model.response.CommonCode;
import com.wenbronk.framework.model.response.ResponseResult;
import com.wenbronk.framework.repository.course.CourseBaseRepository;
import com.wenbronk.framework.repository.course.TeachplanMapper;
import com.wenbronk.framework.repository.course.TeachplanRepository;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-16 20:08
 * description:
 */
@Service
public class CourseBaseService {

    @Autowired
    private TeachplanMapper teachplanMapper;

    @Autowired
    private CourseBaseRepository courseBaseRepository;

    @Autowired
    private TeachplanRepository teachplanRepository;

    public TeachplanNode findTeachplanList(String courseId) {
        return teachplanMapper.selectList(courseId);
    }

    /**
     * 添加课程计划
     */
    @Transactional
    public ResponseResult addTeachplan(Teachplan teachplan) {
        //校验课程id和课程计划名称
        if (teachplan == null ||
                StringUtils.isEmpty(teachplan.getCourseid()) ||
                StringUtils.isEmpty(teachplan.getPname())) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }

        String courseId = teachplan.getCourseid();
        String parentid = teachplan.getParentid();

        // 获取根节点
        if (StringUtils.isEmpty(parentid)) {
            parentid = getTeachplanRoot(courseId);
        }

        Optional<Teachplan> teachplanOptional = teachplanRepository.findById(parentid);
        if (!teachplanOptional.isPresent()) {
            ExceptionCast.cast(CommonCode.INVALID_PARAM);
        }
        //父结点
        Teachplan teachplanParent = teachplanOptional.get();

        //父结点级别
        String parentGrade = teachplanParent.getGrade();
        //设置父结点
        teachplan.setParentid(parentid);
        teachplan.setStatus("0");//未发布
        //子结点的级别，根据父结点来判断
        if (parentGrade.equals("1")) {
            teachplan.setGrade("2");
        } else if (parentGrade.equals("2")) {
            teachplan.setGrade("3");
        }
        //设置课程id
        teachplan.setCourseid(teachplanParent.getCourseid());
        teachplanRepository.save(teachplan);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    private String getTeachplanRoot(String courseId) {
        //校验课程id
        Optional<CourseBase> optional = courseBaseRepository.findById(courseId);
        if (!optional.isPresent()) {
            return null;
        }
        CourseBase courseBase = optional.get();
        List<Teachplan> teachplans = teachplanRepository.findByCourseidAndParentid(courseId, "0");
        if (teachplans == null || teachplans.size() == 0) {
            // 新增一个
            Teachplan teachplanRoot = new Teachplan();
            teachplanRoot.setCourseid(courseId);
            teachplanRoot.setPname(courseBase.getName());
            teachplanRoot.setParentid("0");
            teachplanRoot.setGrade("1");//1级
            teachplanRoot.setStatus("0");//未发布
            teachplanRepository.save(teachplanRoot);
            return teachplanRoot.getId();
        }
        return teachplans.get(0).getId();
    }

}
