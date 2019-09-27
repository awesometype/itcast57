package com.wenbronk.activiti04.domain.system;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 09:27
 * description:
 */
@Entity
@Table(name = "pe_permission")
@Getter
@Setter
@NoArgsConstructor
@DynamicInsert(true)
@DynamicUpdate(true)
public class Permission implements Serializable {
    private static final long serialVersionUID = -4990810027542971546L;
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限类型 1为菜单 2为功能 3为API
     */
    private Integer type;
    /**
     * 权限编码
     */
    private String code;
    /**
     * 权限描述
     */
    private String description;
    private String pid;
    //可见状态
    private String enVisible;

    @ManyToMany(mappedBy = "permissions", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Role> roles = Sets.newHashSet();

    public Permission(String name, Integer type, String code, String description) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.description = description;
    }
}
