package com.wenbronk.framework.repository.course;

import com.xuecheng.framework.domain.course.Teachplan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-16 21:17
 * description:
 */
public interface TeachplanRepository extends JpaRepository<Teachplan, String>, JpaSpecificationExecutor<Teachplan> {

    List<Teachplan> findByCourseidAndParentid(String courseid, String parentid);

}
