package com.wenbronk.ssm02.service;

import com.wenbronk.ssm02.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findUserById(String id);

    void addRoleToUser(String userId, String[] roleIds);
}
