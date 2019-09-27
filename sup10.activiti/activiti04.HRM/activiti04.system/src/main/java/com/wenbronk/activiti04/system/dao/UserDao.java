package com.wenbronk.activiti04.system.dao;

import com.wenbronk.activiti04.domain.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 09:29
 * description:
 */
public interface UserDao extends JpaRepository<User, String> , JpaSpecificationExecutor<User> {

    public User findByMobile(String mobile);

}
