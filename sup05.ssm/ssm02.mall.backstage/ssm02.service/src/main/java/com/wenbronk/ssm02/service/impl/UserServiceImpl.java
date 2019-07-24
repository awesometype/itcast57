package com.wenbronk.ssm02.service.impl;

import com.wenbronk.ssm02.dao.UserDao;
import com.wenbronk.ssm02.domain.Role;
import com.wenbronk.ssm02.domain.UserInfo;
import com.wenbronk.ssm02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author wenbronk
 * @Date 2019-07-23
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(name);
        return new User(userInfo.getUsername(),
                userInfo.getPassword(),
                userInfo.getStatus() == 1,
                true, true, true,
                userInfo.getRoles().parallelStream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
                        .collect(Collectors.toList()));
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    /**
     * 对密码进行加密处理
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId, roleId);
        }
    }

}
