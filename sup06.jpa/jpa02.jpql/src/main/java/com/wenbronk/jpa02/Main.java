package com.wenbronk.jpa02;

import com.wenbronk.jpa02.utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * describe:
 * wenbronk create at 2019/8/2 23:38
 */
public class Main {

    public static EntityManager entityManager = null;


    public static void main(String[] args) {
        EntityTransaction transaction = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            // todoQuery
//            testFindAll();
//            testOrder();
//            testCount();
//            testPage();
            testLike();

            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    /**
     * 查询所有
     *  jpql： from Customer
     *  sql： select * from cst_customer
     */
    public static void testFindAll() {
        Query query = entityManager.createQuery("from Customer");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }

    public static void testOrder() {
        Query query = entityManager.createQuery("from Customer order by custId desc ");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }

    public static void testCount() {
        Query query = entityManager.createQuery("select count(custId) from Customer ");
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);
    }

    public static void testPage() {
        Query query = entityManager.createQuery("from Customer ");
        query.setFirstResult(1);
        query.setMaxResults(2);
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }

    public static void testLike() {
//        Query query = entityManager.createQuery("from Customer where name like ?1");
//        query.setParameter(1, "vi%");

        Query query = entityManager.createQuery("from Customer where name like :name");
        query.setParameter("name", "vi%");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }


}
