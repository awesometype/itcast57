package com.wenbronk.spring.annotation.service;

import com.wenbronk.spring.annotation.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-06-25
 */
public interface AccountService {
    List<User> find() throws SQLException;
}
