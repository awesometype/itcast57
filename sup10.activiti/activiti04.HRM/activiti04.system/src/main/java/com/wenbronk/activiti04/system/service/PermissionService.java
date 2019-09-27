package com.wenbronk.activiti04.system.service;

import com.wenbronk.activiti04.common.entity.ResultCode;
import com.wenbronk.activiti04.common.exception.CommonException;
import com.wenbronk.activiti04.common.service.BaseService;
import com.wenbronk.activiti04.common.utils.BeanMapUtils;
import com.wenbronk.activiti04.common.utils.IdWorker;
import com.wenbronk.activiti04.common.utils.PermissionConstants;
import com.wenbronk.activiti04.domain.system.Permission;
import com.wenbronk.activiti04.domain.system.PermissionApi;
import com.wenbronk.activiti04.domain.system.PermissionMenu;
import com.wenbronk.activiti04.domain.system.PermissionPoint;
import com.wenbronk.activiti04.system.dao.PermissionApiDao;
import com.wenbronk.activiti04.system.dao.PermissionDao;
import com.wenbronk.activiti04.system.dao.PermissionMenuDao;
import com.wenbronk.activiti04.system.dao.PermissionPointDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-28 10:31
 * description:
 */
@Service
public class PermissionService extends BaseService<Permission> {

    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private PermissionMenuDao permissionMenuDao;
    @Autowired
    private PermissionPointDao permissionPointDao;
    @Autowired
    private PermissionApiDao permissionApiDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    public void save(Map<String, Object> map) throws Exception {
        Permission permission = BeanMapUtils.mapToBean(map, Permission.class);
        String id = idWorker.nextId();
        permission.setId(id);

        //2.根据类型构造不同的资源对象（菜单，按钮，api）
        int type = permission.getType();
        switch (type) {
            case PermissionConstants.PERMISSION_MENU:
                PermissionMenu permissionMenu = BeanMapUtils.mapToBean(map, PermissionMenu.class);
                permissionMenu.setId(id);
                permissionMenuDao.save(permissionMenu);
                break;
            case PermissionConstants.PERMISSION_POINT:
                PermissionPoint point =
                        BeanMapUtils.mapToBean(map,PermissionPoint.class);
                point.setId(id);
                permissionPointDao.save(point);
                break;
            case PermissionConstants.PERMISSION_API:
                PermissionApi api = BeanMapUtils.mapToBean(map,PermissionApi.class);
                api.setId(id);
                permissionApiDao.save(api);
                break;
            default:
                throw new CommonException(ResultCode.FAIL);
        }
        permissionDao.save(permission);
    }

    /**
     * 更新
     */
    public void update(Map<String, Object> map) throws Exception {
        Permission perm = BeanMapUtils.mapToBean(map, Permission.class);
        Optional<Permission> permissionOpt = permissionDao.findById(perm.getId());
        if (permissionOpt.isPresent()) {
            Permission permission = permissionOpt.get();
            permission.setName(perm.getName());
            permission.setCode(perm.getCode());
            permission.setDescription(perm.getDescription());
            permission.setEnVisible(perm.getEnVisible());

            int type = perm.getType();
            switch (type) {
                case PermissionConstants.PERMISSION_MENU:
                    PermissionMenu menu = BeanMapUtils.mapToBean(map,PermissionMenu.class);
                    menu.setId(perm.getId());
                    permissionMenuDao.save(menu);
                    break;
                case PermissionConstants.PERMISSION_POINT:
                    PermissionPoint point =
                            BeanMapUtils.mapToBean(map,PermissionPoint.class);
                    point.setId(perm.getId());
                    permissionPointDao.save(point);
                    break;
                case PermissionConstants.PERMISSION_API:
                    PermissionApi api = BeanMapUtils.mapToBean(map,PermissionApi.class);
                    api.setId(perm.getId());
                    permissionApiDao.save(api);
                    break;
                default:
                    throw new CommonException(ResultCode.FAIL);
            }
            //3.保存
            permissionDao.save(permission);
        }
    }

    /**
     * 根据id查询
     */
    public Map<String, Object> findById(String id) throws Exception {
        Permission perm = permissionDao.findById(id).get();
        int type = perm.getType();
        Object object = null;
        if(type == PermissionConstants.PERMISSION_MENU) {
            object = permissionMenuDao.findById(id).get();
        }else if (type == PermissionConstants.PERMISSION_POINT) {
            object = permissionPointDao.findById(id).get();
        }else if (type == PermissionConstants.PERMISSION_API) {
            object = permissionApiDao.findById(id).get();
        }else {
            throw new CommonException(ResultCode.FAIL);
        }
        Map<String, Object> map = BeanMapUtils.beanToMap(object);
        map.put("name",perm.getName());
        map.put("type",perm.getType());
        map.put("code",perm.getCode());
        map.put("description",perm.getDescription());
        map.put("pid",perm.getPid());
        map.put("enVisible",perm.getEnVisible());
        return map;
    }

    /**
     * 4.查询全部
     * type : 查询全部权限列表type：0：菜单 + 按钮（权限点） 1：菜单2：按钮（权限点）3：API接
     口
     * enVisible : 0：查询所有saas平台的最高权限，1：查询企业的权限
     * pid ：父id
     */
    public List<Permission> findAll(Map<String, Object> map) {
        //1.需要查询条件
        Specification<Permission> spec = new Specification<Permission>() {
            /**
             * 动态拼接查询条件
             */
            @Override
            public Predicate toPredicate(Root<Permission> root, CriteriaQuery<?>
                    criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                //根据父id查询
                if(!StringUtils.isEmpty(map.get("pid"))) {
                    list.add(criteriaBuilder.equal(root.get("pid").as(String.class),
                            (String)map.get("pid")));
                }
                //根据enVisible查询
                if(!StringUtils.isEmpty(map.get("enVisible"))) {
                    list.add(criteriaBuilder.equal(root.get("enVisible").as(String.class),
                            (String)map.get("enVisible")));
                }
                //根据类型 type
                if(!StringUtils.isEmpty(map.get("type"))) {
                   //  1.2.4 控制器
                    String ty = (String) map.get("type");
                    CriteriaBuilder.In<Object> in =
                            criteriaBuilder.in(root.get("type"));
                    if("0".equals(ty)) {
                        in.value(1).value(2);
                    }else{
                        in.value(Integer.parseInt(ty));
                    }
                    list.add(in);
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };
        return permissionDao.findAll(spec);
    }

    /**
     * 5.根据id删除
     * //1.删除权限
     * //2.删除权限对应的资源
     *
     */
    public void deleteById(String id) throws Exception {
        //1.通过传递的权限id查询权限
        Permission permission = permissionDao.findById(id).get();
        permissionDao.delete(permission);
        //2.根据类型构造不同的资源
        int type = permission.getType();
        switch (type) {
            case PermissionConstants.PERMISSION_MENU:
                permissionMenuDao.deleteById(id);
                break;
            case PermissionConstants.PERMISSION_POINT:
                permissionPointDao.deleteById(id);
                break;
            case PermissionConstants.PERMISSION_API:
                permissionApiDao.deleteById(id);
                break;
            default:
                throw new CommonException(ResultCode.FAIL);
        }
    }
}
