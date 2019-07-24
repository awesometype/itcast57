package com.wenbronk.ssm02.controller;

import com.wenbronk.ssm02.domain.Role;
import com.wenbronk.ssm02.domain.UserInfo;
import com.wenbronk.ssm02.service.RoleService;
import com.wenbronk.ssm02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-23
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    @RolesAllowed({"USER", "ADMIN"})
    public String findAll(Model model) {
        List<UserInfo> userInfos = userService.findAll();
        model.addAttribute("userList", userInfos);
        return "user-list";
    }

    @RequestMapping("save")
    public String save(UserInfo userInfo) {
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public String findById(String id) {
        // TODO
        return "user-show1";
    }

    /**
     * 查询用户可以添加的角色
     */
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String id, Model model) {
        UserInfo user = userService.findUserById(id);
        List<Role> roles = roleService.findOtherRoles(id);
        model.addAttribute("user", user);
        model.addAttribute("roleList", roles);
        return "user-role-add";
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String[] ids) {
        userService.addRoleToUser(userId, ids);
        return "redirect:findAll";
    }

}
