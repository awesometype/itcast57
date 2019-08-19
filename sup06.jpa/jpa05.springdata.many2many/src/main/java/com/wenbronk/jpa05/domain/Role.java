package com.wenbronk.jpa05.domain;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-08 21:24
 * description:
 */
@Entity
@Table(name = "sys_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_group")
    private String roleGroup;

//    @ManyToMany(targetEntity = User.class)
//    @JoinTable(name = "sys_user_role",
//            joinColumns = {@JoinColumn(name = "sys_user_id", referencedColumnName = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "sys_role_id", referencedColumnName = "role_id")}
//    )
    // 放弃外键维护
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<User> users = Lists.newArrayList();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
