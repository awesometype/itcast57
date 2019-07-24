package com.wenbronk.ssm02.dao;

import com.wenbronk.ssm02.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-23
 */
public interface RoleDao {

    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role(id, roleName, roleDesc) value(UUID(), #{roleName}, #{roleDesc})")
    void save(Role role);

    @Select("select * from role left join users_role as ur on role.id = ur.roleId where ur.userId = #{userId}")
    @ResultMap(value = "role")
    List<Role> findRoleByUserId(String userId);

    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(String userId);

    @Select("select * from role where id = #{id}")
    @Results(id = "role", value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.wenbronk.ssm02.dao.PermissionDao.findPermissionByRoleId"))
    })
    Role findRoleById(String id);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
