package com.wenbronk.jpa04.dao;

import com.wenbronk.jpa04.domain.Customer;
import com.wenbronk.jpa04.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-05 22:48
 * description:
 */
public interface LinkManDao extends JpaRepository<LinkMan, Long>, JpaSpecificationExecutor<Customer> {
}
