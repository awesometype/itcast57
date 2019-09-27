package com.wenbronk.activiti04.system.dao;

import com.wenbronk.activiti04.domain.system.PermissionMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 10:29
 * description:
 */
public interface PermissionMenuDao extends JpaRepository<PermissionMenu, String>, JpaSpecificationExecutor<PermissionMenu> {
}
