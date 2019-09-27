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
@Table(name = "pe_permission_api")
@Getter
@Setter
public class PermissionApi implements Serializable {
    private static final long serialVersionUID = -1803315043290784820L;
    @Id
    private String id;
    private String apiUrl;
    private String apiMethod;
    private String apiLevel;//权限等级，1为通用接口权限，2为需校验接口权限
}
