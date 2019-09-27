package com.wenbronk.activiti04.company.service;

import com.wenbronk.activiti04.common.service.BaseService;
import com.wenbronk.activiti04.common.utils.IdWorker;
import com.wenbronk.activiti04.company.dao.DepartmentRespository;
import com.wenbronk.activiti04.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-27 10:17
 * description:
 */
@Service
public class DepartmentService extends BaseService<Department> {

    @Autowired
    private DepartmentRespository departmentRespository;

    @Autowired
    private IdWorker idWorker;

    public void save(Department department) {
        department.setId(idWorker.nextId());
        department.setCreateTime(new Date());
        departmentRespository.save(department);
    }

    public void update(Department department) {
        Optional<Department> departmentOptional = departmentRespository.findById(department.getId());
        departmentOptional.ifPresent(sourceDepartment -> {
            sourceDepartment.setName(department.getName());
            sourceDepartment.setParentId(department.getParentId());
            sourceDepartment.setManagerId(department.getManagerId());
            sourceDepartment.setIntroduce(department.getIntroduce());
            sourceDepartment.setManager(department.getManager());
            departmentRespository.save(sourceDepartment);
        });
    }

    public Department findById(String id) {
        return departmentRespository.findById(id).get();
    }

    /**
     * 删除部门
     *
     * @param id 部门ID
     */
    public void delete(String id) {
        departmentRespository.deleteById(id);
    }

    /**
     * 获取部门列表
     */
    public List<Department> findAll(String companyId) {
        return departmentRespository.findAll(getEqualSpecification("companyId", companyId));
    }
}
