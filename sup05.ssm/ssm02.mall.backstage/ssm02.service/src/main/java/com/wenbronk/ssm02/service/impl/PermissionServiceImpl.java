package com.wenbronk.ssm02.service.impl;

import com.wenbronk.ssm02.dao.PermissionDao;
import com.wenbronk.ssm02.domain.Permission;
import com.wenbronk.ssm02.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-23
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    @Override
    public List<Permission> findOtherPermissionByRoleId(String id) {
        return permissionDao.findOtherPermissionByRoleId(id);
    }


}
