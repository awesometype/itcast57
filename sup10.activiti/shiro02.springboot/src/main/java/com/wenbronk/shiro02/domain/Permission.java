package com.wenbronk.shiro02.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "pe_permission")
@Setter
@Getter
@NoArgsConstructor
public class Permission implements Serializable {
    private static final long serialVersionUID = -4990810027542971546L;
    /**
     * 主键
     */
    @Id
    private String id;
    private String name;
    private String code;
    private String description;
}