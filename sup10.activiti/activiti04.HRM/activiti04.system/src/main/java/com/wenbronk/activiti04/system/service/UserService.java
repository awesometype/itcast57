package com.wenbronk.activiti04.system.service;

import com.wenbronk.activiti04.common.service.BaseService;
import com.wenbronk.activiti04.common.utils.IdWorker;
import com.wenbronk.activiti04.domain.system.Role;
import com.wenbronk.activiti04.domain.system.User;
import com.wenbronk.activiti04.system.dao.RoleDao;
import com.wenbronk.activiti04.system.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 09:29
 * description:
 */
@Service
public class UserService extends BaseService<User> {

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public User findByMobileAndPassword(String mobile, String password) {
        User user = userDao.findByMobile(mobile);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public void save(User user) {
        //填充其他参数
        user.setId(idWorker.nextId() + "");
        user.setCreateTime(new Date()); //创建时间
        user.setPassword("123456");//设置默认登录密码
        user.setEnableState(1);//状态
        userDao.save(user);
    }

    /**
     * 更新用户
     */
    public void update(User user) {
        User targer = userDao.getOne(user.getId());
        targer.setPassword(user.getPassword());
        targer.setUsername(user.getUsername());
        targer.setMobile(user.getMobile());
        targer.setDepartmentId(user.getDepartmentId());
        targer.setDepartmentName(user.getDepartmentName());
        userDao.save(targer);
    }

    /**
     * 根据ID查询用户
     */
    public User findById(String id) {
        return userDao.findById(id).get();
    }

    /**
     * 删除部门
     *
     * @param id 部门ID
     */
    public void delete(String id) {
        userDao.deleteById(id);
    }

    /**
     * 调整部门
     */
    public void changeDept(String deptId, String deptName, List<String> ids) {
        for (String id : ids) {
            User user = userDao.findById(id).get();
            user.setDepartmentName(deptName);
            user.setDepartmentId(deptId);
            userDao.save(user);
        }
    }

    /**
     * 分配角色
     */
    public void assignRoles(String userId, List<String> roleIds) {
        User user = userDao.findById(userId).get();
        Set<Role> roles = new HashSet<>();
        for (String id : roleIds) {
            Role role = roleDao.findById(id).get();
            roles.add(role);
        }
        //设置用户和角色之间的关系
        user.setRoles(roles);
        userDao.save(user);
    }

    public Page<User> findSearch(Map<String, Object> map, int page, int size) {
        return userDao.findAll(createSpecification(map), PageRequest.of(page - 1, size));
    }

    /**
     * 动态条件构建
     *
     * @param searchMap
     * @return
     */
    private Specification<User> createSpecification(Map searchMap) {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                // ID
                if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
                    predicateList.add(cb.equal(root.get("id").as(String.class),
                            (String) searchMap.get("id")));
                }
                // 手机号码
                if (searchMap.get("mobile") != null &&
                        !"".equals(searchMap.get("mobile"))) {
                    predicateList.add(cb.equal(root.get("mobile").as(String.class),
                            (String) searchMap.get("mobile")));
                }
                    // 用户ID
                if (searchMap.get("departmentId") != null &&
                        !"".equals(searchMap.get("departmentId"))) {
                    predicateList.add(cb.like(root.get("departmentId").as(String.class),
                            (String) searchMap.get("departmentId")));
                }
                    // 标题
                if (searchMap.get("formOfEmployment") != null &&
                        !"".equals(searchMap.get("formOfEmployment"))) {
                    predicateList.add(cb.like(root.get("formOfEmployment").as(String.class),
                            (String) searchMap.get("formOfEmployment")));
                }
                if (searchMap.get("companyId") != null &&
                        !"".equals(searchMap.get("companyId"))) {
                    predicateList.add(cb.like(root.get("companyId").as(String.class),
                            (String) searchMap.get("companyId")));
                }
                if (searchMap.get("hasDept") != null &&
                        !"".equals(searchMap.get("hasDept"))) {
                    if ("0".equals((String) searchMap.get("hasDept"))) {
                        predicateList.add(cb.isNull(root.get("departmentId")));
                    } else {
                        predicateList.add(cb.isNotNull(root.get("departmentId")));
                    }
                }
                return cb.and(predicateList.toArray(new
                        Predicate[predicateList.size()]));
            }
        };
    }

    public User findByMobile(String mobile) {
        return userDao.findByMobile(mobile);
    }
}
