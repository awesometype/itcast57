package com.wenbronk.jpa05.test;

import com.wenbronk.jpa05.dao.RoleDao;
import com.wenbronk.jpa05.dao.UserDao;
import com.wenbronk.jpa05.domain.Role;
import com.wenbronk.jpa05.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-08 21:46
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class Many2ManyTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testMany2Many() {
        User user = new User();
        user.setUserName("vini");
        user.setAge(18);

        Role role = new Role();
        role.setRoleName("admin");

        user.getRoles().add(role);
        role.getUsers().add(user);

        roleDao.save(role);
        userDao.save(user);
    }

    @Test
    public void testCasecadeAdd() {
        User user = new User();
        user.setUserName("vini");
        user.setAge(18);

        Role role = new Role();
        role.setRoleName("admin");

        user.getRoles().add(role);

        userDao.save(user);
    }

    @Test
    public void testRemove() {
        Optional<User> user = userDao.findOne((root, query, build) -> {
            Path<Object> userId = root.get("userId");
            return build.equal(userId, 3L);
        });
        user.ifPresent(user1 -> {
            userDao.delete(user1);
        });
    }
}
