package com.wenbronk.ssm02.service;

import com.wenbronk.ssm02.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findOtherPermissionByRoleId(String id);
}
