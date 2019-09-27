package com.wenbronk.activiti04.domain.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-29 13:16
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResult {
    private String mobile;
    private String username;
    private String company;
    private Map roles;

    public ProfileResult(User user) {
        this.mobile = user.getMobile();
        this.username = user.getUsername();
        this.company = user.getCompanyName();
        //角色数据
        Set<String> menus = new HashSet<>();
        Set<String> points = new HashSet<>();
        Set<String> apis = new HashSet<>();
        Map rolesMap = new HashMap<>();
        for (Role role : user.getRoles()) {
            for (Permission perm : role.getPermissions()) {
                String code = perm.getCode();
                if (perm.getType() == 1) {
                    menus.add(code);
                } else if (perm.getType() == 2) {
                    points.add(code);
                } else {
                    apis.add(code);
                }
            }
        }
        rolesMap.put("menus", menus);
        rolesMap.put("points", points);
        rolesMap.put("apis", points);
        this.roles = rolesMap;
    }

    /**
     *
     * @param user
     */
    public ProfileResult(User user, List<Permission> list) {
        this.mobile = user.getMobile();
        this.username = user.getUsername();
        this.company = user.getCompanyName();

        Set<String> menus = new HashSet<>();
        Set<String> points = new HashSet<>();
        Set<String> apis = new HashSet<>();

        for (Permission perm : list) {
            String code = perm.getCode();
            if(perm.getType() == 1) {
                menus.add(code);
            }else if(perm.getType() == 2) {
                points.add(code);
            }else {
                apis.add(code);
            }
        }
        this.roles.put("menus",menus);
        this.roles.put("points",points);
        this.roles.put("apis",apis);
    }
}
