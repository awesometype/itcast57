package com.wenbronk.activiti04.system.dao;

import com.wenbronk.activiti04.domain.system.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 09:30
 * description:
 */
public interface PermissionDao extends JpaRepository<Permission, String>, JpaSpecificationExecutor<Permission> {
}
