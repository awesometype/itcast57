package com.wenbronk.spring.annotation.dao;

import com.wenbronk.spring.annotation.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    List<User> find() throws SQLException;
}
