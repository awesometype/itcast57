package com.wenbronk.activiti04.system.controller;

import com.wenbronk.activiti04.common.entity.PageResult;
import com.wenbronk.activiti04.common.entity.Result;
import com.wenbronk.activiti04.common.entity.ResultCode;
import com.wenbronk.activiti04.domain.system.Role;
import com.wenbronk.activiti04.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 09:41
 * description:
 */
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //添加角色
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public Result add(@RequestBody Role role) throws Exception {
        String companyId = "1";
        role.setCompanyId(companyId);
        roleService.save(role);
        return Result.SUCCESS();
    }
    //更新角色
    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(name = "id") String id, @RequestBody Role role)
            throws Exception {
        roleService.update(role);
        return Result.SUCCESS();
    }

    //删除角色
    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(name = "id") String id) throws Exception {
        roleService.delete(id);
        return Result.SUCCESS();
    }
    /**
     * 根据ID获取角色信息
     */
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        Role role = roleService.findById(id);
        return new Result(ResultCode.SUCCESS,role);
    }
    /**
     * 分页查询角色
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public Result findByPage(int page,int pagesize,Role role) throws Exception {
        String companyId = "1166177381798133760";
        Page<Role> searchPage = roleService.findSearch(companyId, page, pagesize);
        PageResult<Role> pr = new
                PageResult(searchPage.getTotalElements(),searchPage.getContent());
        return new Result(ResultCode.SUCCESS,pr);
    }

    /**
     * 分页查询角色
     */
    @RequestMapping(value = "/role/list", method = RequestMethod.GET)
    public Result findList() throws Exception {
        String companyId = "1166177381798133760";
        Page<Role> searchPage = roleService.findSearch(companyId, 1, 999);
        return new Result(ResultCode.SUCCESS,searchPage.getContent());
    }

}
