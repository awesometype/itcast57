package com.wenbronk.activiti04.company.dao;

import com.wenbronk.activiti04.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-26 09:32
 * description:
 */
public interface CompanyRespository extends JpaRepository<Company, String>, JpaSpecificationExecutor<Company> {
}
