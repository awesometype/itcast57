package com.wenbronk.jpa05.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-08 21:24
 * description:
 */
public interface UserDao extends JpaRepository<User, Long> {
}
