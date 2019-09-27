package com.wenbronk.activiti04.domain.system;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 10:23
 * description:
 */
@Entity
@Table(name = "pe_permission_point")
@Getter
@Setter
public class PermissionPoint implements Serializable {
    private static final long serialVersionUID = -1002411490113957485L;
    @Id
    private String id;
    private String pointClass;
    private String pointIcon;
    private String pointStatus;
}
