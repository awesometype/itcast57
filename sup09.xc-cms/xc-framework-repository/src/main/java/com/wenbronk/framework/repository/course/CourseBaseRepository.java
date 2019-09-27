package com.wenbronk.framework.repository.course;

import com.xuecheng.framework.domain.course.CourseBase;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-16 10:47
 * description:
 */
public interface CourseBaseRepository extends JpaRepository<CourseBase, String>, JpaSpecificationExecutor<CourseBase> {
}
