package com.wenbronk.ssm02.controller;

import com.wenbronk.ssm02.domain.Permission;
import com.wenbronk.ssm02.domain.Role;
import com.wenbronk.ssm02.service.PermissionService;
import com.wenbronk.ssm02.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-23
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll")
    @Secured("ROLE_ADMIND")
    public ModelAndView findAll() {
        List<Role> roleList = roleService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll";
    }

    /**
     * 查询角色可添加的权限
     */
    @RequestMapping("/findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(String id, Model model) {
        Role role = roleService.findRoleById(id);
        List<Permission> permissionsList = permissionService.findOtherPermissionByRoleId(id);
        model.addAttribute("role", role);
        model.addAttribute("permissionList", permissionsList);
        return "role-permission-add";
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam("roleId") String roleId, @RequestParam("ids") String[] permissions) {
        roleService.addPermissionToRole(roleId, permissions);
        return "redirect:findAll";
    }

}
