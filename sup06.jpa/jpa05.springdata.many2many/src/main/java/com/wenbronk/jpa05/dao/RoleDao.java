package com.wenbronk.jpa05.dao;

import com.wenbronk.jpa05.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-08 21:24
 * description:
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}
