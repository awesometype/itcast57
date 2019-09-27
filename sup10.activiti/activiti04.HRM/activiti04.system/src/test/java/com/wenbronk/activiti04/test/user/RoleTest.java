package com.wenbronk.activiti04.test.user;

import com.google.common.collect.Lists;
import com.wenbronk.activiti04.domain.system.Role;
import com.wenbronk.activiti04.system.SystemApplication;
import com.wenbronk.activiti04.system.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-29 10:20
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SystemApplication.class})
public class RoleTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testRoleAdd() {
        getRoleList().forEach(role -> {
            roleService.save(role);
        });

    }

    public List<Role> getRoleList() {
        ArrayList<Role> roles = Lists.newArrayList();
        roles.add(getRole("hrbp", "人事经理", "wenbronk"));
        roles.add(getRole("root", "系统管理员", "wenbronk"));
        roles.add(getRole("hr", "人事专员", "wenbronk"));
        roles.add(getRole("salery", "薪资专员", "wenbronk"));
        return roles;
    }

    public Role getRole(String name, String description, String companyId) {
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        role.setCompanyId(companyId);
        return role;
    }

}
