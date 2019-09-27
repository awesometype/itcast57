package com.wenbronk.activiti04.company.dao;

import com.wenbronk.activiti04.domain.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-27 10:16
 * description:
 */
public interface DepartmentRespository extends JpaRepository<Department, String>, JpaSpecificationExecutor<Department> {
}
