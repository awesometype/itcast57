package com.wenbronk.activiti04.system.dao;

import com.wenbronk.activiti04.domain.system.PermissionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 10:28
 * description:
 */
public interface PermissionPointDao extends JpaRepository<PermissionPoint, String>, JpaSpecificationExecutor<PermissionPoint> {
}
