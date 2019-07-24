package com.wenbronk.ssm02.dao;

import com.wenbronk.ssm02.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-23
 */
public interface PermissionDao {

    @Select("select * from permission")
    public List<Permission> findAll();

    @Insert("insert into permission(id, permissionName,url) value(UUID(), #{permissionName},#{url})")
    void save(Permission permission);

    @Select("select * from permission p left join role_permission as rp on p.id = rp.permissionId where rp.roleId = #{roleId}")
    List<Permission> findPermissionByRoleId(String roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissionByRoleId(String id);
}
