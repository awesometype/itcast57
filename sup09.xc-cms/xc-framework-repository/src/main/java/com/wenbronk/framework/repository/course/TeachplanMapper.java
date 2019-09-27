package com.wenbronk.framework.repository.course;

import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-16 11:35
 * description:
 */
@Mapper
public interface TeachplanMapper {

    TeachplanNode selectList(String couseId);

}
