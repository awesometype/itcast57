package com.wenbronk.activiti04.system.controller;

import com.google.common.collect.Maps;
import com.wenbronk.activiti04.common.controller.BaseController;
import com.wenbronk.activiti04.common.entity.PageResult;
import com.wenbronk.activiti04.common.entity.Result;
import com.wenbronk.activiti04.common.entity.ResultCode;
import com.wenbronk.activiti04.common.exception.CommonException;
import com.wenbronk.activiti04.common.utils.JwtsUtils;
import com.wenbronk.activiti04.common.utils.PermissionConstants;
import com.wenbronk.activiti04.domain.system.Permission;
import com.wenbronk.activiti04.domain.system.ProfileResult;
import com.wenbronk.activiti04.domain.system.Role;
import com.wenbronk.activiti04.domain.system.User;
import com.wenbronk.activiti04.system.service.PermissionService;
import com.wenbronk.activiti04.system.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 09:36
 * description:
 */
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private JwtsUtils jwtsUtils;

    //保存用户
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Result add(@RequestBody User user) throws Exception {
        user.setCompanyId(parseCompanyId());
        user.setCompanyName(parseCompanyName());
        userService.save(user);
        return Result.SUCCESS();
    }

    //更新用户
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(name = "id") String id, @RequestBody User user)
            throws Exception {
        userService.update(user);
        return Result.SUCCESS();
    }
    //删除用户
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(name = "id") String id) throws Exception {
        userService.delete(id);
        return Result.SUCCESS();
    }

    /**
     * 根据ID查询用户
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(name = "id") String id) throws Exception {
        User user = userService.findById(id);
        return new Result(ResultCode.SUCCESS,user);
    }
    /**
     * 分页查询用户
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Result findByPage(int page,int size,@RequestParam Map<String,Object> map) throws Exception {
        map.put("companyId",parseCompanyId());
        Page<User> searchPage = userService.findSearch(map, page, size);
        PageResult<User> pr = new PageResult(searchPage.getTotalElements(),searchPage.getContent());
        return new Result(ResultCode.SUCCESS,pr);
    }

    /**
     * 分配角色
     */
    @RequestMapping("/user/assignRoles")
    public Result assignRoles(@RequestBody Map<String, Object> map) {
        String userId = (String) map.get("id");
        List<String> roleIds = (List<String>) map.get("roleIds");
        userService.assignRoles(userId, roleIds);
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 登陆
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> loginMap) {
        String mobile = loginMap.get("mobile");
        String password = loginMap.get("password");
        User user = userService.findByMobile(mobile);
            //登录失败
        if(user == null || !user.getPassword().equals(password)) {
            return new Result(ResultCode.MOBILEORPASSWORDERROR);
        }else {
            //登录成功
            //api权限字符串
            StringBuilder sb = new StringBuilder();
            //获取到所有的可访问API权限
            for (Role role : user.getRoles()) {
                for (Permission perm : role.getPermissions()) {
                    if(perm.getType() == PermissionConstants.PERMISSION_API) {
                        sb.append(perm.getCode()).append(",");
                    }
                }
            }
            Map<String,Object> map = new HashMap<>();
            map.put("apis",sb.toString());//可访问的api权限字符串
            map.put("companyId",user.getCompanyId());
            map.put("companyName",user.getCompanyName());
            String token = jwtsUtils.createJwts(user.getId(), user.getUsername(), map);
            return new Result(ResultCode.SUCCESS,token);
        }
    }

    /**
     * 登陆后获取用户信息
     */
    @RequestMapping("/profile")
    public Result profile(HttpServletRequest request) throws Exception{

        String userId = claims.getId();

        //查询用户
        User user = userService.findById(userId);
        ProfileResult result = null;
        if("user".equals(user.getLevel())) {
            result = new ProfileResult(user);
        }else {
            Map map = new HashMap();
            if("coAdmin".equals(user.getLevel())) {
                map.put("enVisible","1");
            }
            List<Permission> list = permissionService.findAll(map);
            result = new ProfileResult(user,list);
        }
        return new Result(ResultCode.SUCCESS,result);
    }



}