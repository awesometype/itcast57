package com.wenbronk.ssm02.controller;

import com.wenbronk.ssm02.domain.Permission;
import com.wenbronk.ssm02.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-23
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Permission> permissionList = permissionService.findAll();
        model.addAttribute("permissionList", permissionList);
        return "permission-list";
    }

    @RequestMapping("/save")
    public String save(Permission permission) {
        permissionService.save(permission);
        return "redirect:findAll";
    }

}
