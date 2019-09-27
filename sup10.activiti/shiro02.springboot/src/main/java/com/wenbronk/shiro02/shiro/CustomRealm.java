package com.wenbronk.shiro02.shiro;

import com.wenbronk.shiro02.domain.Permission;
import com.wenbronk.shiro02.domain.Role;
import com.wenbronk.shiro02.domain.User;
import com.wenbronk.shiro02.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-04 09:52
 * description:
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    /**
     * 后授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();

        Set<String> roleNames = user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        Set<String> permissionNames = user.getRoles().stream().flatMap(role -> {
            return role.getPermissions().stream().map(Permission::getCode);
        }).collect(Collectors.toSet());

        // 构造认证数据
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roleNames);
        simpleAuthorizationInfo.setStringPermissions(permissionNames);
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

        User user = userService.findByName(username);
        // 密码是否匹配
        if (user != null && passwd.equals(user.getPassword())) {
            return new SimpleAuthenticationInfo(user, passwd, this.getName());
        }
        return null;
    }
}
