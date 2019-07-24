package com.wenbronk.ssm02.service.impl;

import com.wenbronk.ssm02.dao.RoleDao;
import com.wenbronk.ssm02.domain.Role;
import com.wenbronk.ssm02.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-23
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRoles(String id) {
        return roleDao.findOtherRoles(id);
    }

    @Override
    public Role findRoleById(String id) {
        return roleDao.findRoleById(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissions) {
        for (String permissionId : permissions) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }
}
