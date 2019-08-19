package com.wenbronk.jpa03;

import com.wenbronk.jpa03.dao.CustomerPersistence;
import com.wenbronk.jpa03.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn}>
 * @Date 2019-08-04 22:43
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class SpecicationTest {

    @Autowired
    private CustomerPersistence customerPersistence;

//    @Test
//    public void testSpec() {
//        Specification<Customer> specification = new Specification<>() {
//            @Override
//            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                // 获取比较的属性
//                Path<Object> custId = root.get("name");
//                // 构造查询条件
//                Predicate predicate = criteriaBuilder.equal(custId, "vini");
//                return predicate;
//            }
//        };
//        Optional<Customer> customer = customerPersistence.findOne(specification);
//        customer.ifPresent(System.out::println);
//    }

    @Test
    public void testMultiSpec() {
        List<Customer> customerList = customerPersistence.findAll((root, query, criteriaBuilder) -> {
            Path<Object> custName = root.get("name");
            Path<Object> custLevel = root.get("custLevel");

            Predicate p1 = criteriaBuilder.equal(custName, "vini3");
            Predicate p2 = criteriaBuilder.equal(custLevel, "VIP客户");
            return criteriaBuilder.and(p1, p2);
        });
        customerList.forEach(System.out::println);
    }

    @Test
    public void testLikeAndSort() {
        Sort sort = new Sort(Sort.Direction.DESC, "custId");
        Specification<Customer> specification = (root, query, cb) -> {
            Path<Object> name = root.get("name");
            Path<Object> custSource = root.get("custSource");

            Predicate p1 = cb.like(name.as(String.class), "vini%");
            Predicate p2 = cb.equal(custSource, "网络");
            return cb.and(p1, p2);
        };
        List<Customer> customerList = customerPersistence.findAll(specification, sort);
        customerList.forEach(System.out::println);
    }

    @Test
    public void testPage() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Specification<Customer> specification = (root, query, cb) -> {
            Path<Object> name = root.get("name");
            return cb.like(name.as(String.class), "vini%");
        };
        Page<Customer> all = customerPersistence.findAll(specification, pageRequest);
        all.forEach(System.out::println);
        System.out.println(all.getTotalPages());
        System.out.println(all.getTotalElements());
        System.out.println(all.getContent());
    }

}
