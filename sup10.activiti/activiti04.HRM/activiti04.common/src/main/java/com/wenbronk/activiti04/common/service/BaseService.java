package com.wenbronk.activiti04.common.service;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-27 10:07
 * description:
 */
public class BaseService<T> {

    protected Specification<T> getEqualSpecification(String key, String value) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get(key).as(String.class),value);
            }
        };
    }

}
