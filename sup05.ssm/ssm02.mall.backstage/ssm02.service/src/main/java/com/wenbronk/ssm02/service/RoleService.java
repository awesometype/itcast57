package com.wenbronk.ssm02.service;

import com.wenbronk.ssm02.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    List<Role> findOtherRoles(String id);

    Role findRoleById(String id);

    void addPermissionToRole(String roleId, String[] permissions);
}
