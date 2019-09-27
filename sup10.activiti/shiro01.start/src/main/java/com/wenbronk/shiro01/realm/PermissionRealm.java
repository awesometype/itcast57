package com.wenbronk.shiro01.realm;

import com.google.common.collect.Lists;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-03 10:50
 * description:
 */
public class PermissionRealm extends AuthorizingRealm {

    @Override
    public void setName(String name) {
        super.setName("testPermissionReal");
    }

    /**
     * 后授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();

        // 授权， 从正式系统查询用户权限， 并授权
        ArrayList<String> permissions = Lists.newArrayList("user:save", "user:update");
        ArrayList<String> roles = Lists.newArrayList("role1", "role2");

        // 构造权限数据
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 5.将查询的权限数据保存到simpleAuthorizationInfo
        simpleAuthorizationInfo.addStringPermissions(permissions);
        // 6.将查询的角色数据保存到simpleAuthorizationInfo
        simpleAuthorizationInfo.addRoles(roles);

        return simpleAuthorizationInfo;
    }

    /**
     * 先认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();
        String passwd = new String(usernamePasswordToken.getPassword());

        // 从数据库中查询， 比较密码是否一致
        if ("123".equals(passwd)) {
            return new SimpleAuthenticationInfo(username, passwd, this.getName());
        }
        // 返回null 或者抛出异常， 都是验证失败
        return null;
    }
}
