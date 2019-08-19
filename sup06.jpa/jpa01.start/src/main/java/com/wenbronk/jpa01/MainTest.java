package com.wenbronk.jpa01;

import com.wenbronk.jpa01.domain.Customer;
import com.wenbronk.jpa01.utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * describe:
 * wenbronk create at 2019/7/30 08:26
 */
public class MainTest {

//    public static void main(String[] args) {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_starter");
//        EntityManager entityManager = factory.createEntityManager();
//        // 开启事务
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        Customer cutomer = new Customer();
//        cutomer.setName("vini");
//
//        entityManager.persist(cutomer);
//
//        transaction.commit();
//        entityManager.close();
//        factory.close();
//    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
//        mainTest.save();
        mainTest.testFind();
//        mainTest.testReference();

    }

    /**
     * 测试jpa的保存
     *      案例：保存一个客户到数据库中
     *  Jpa的操作步骤
     *     1.加载配置文件创建工厂（实体管理器工厂）对象
     *     2.通过实体管理器工厂获取实体管理器
     *     3.获取事务对象，开启事务
     *     4.完成增删改查操作
     *     5.提交事务（回滚事务）
     *     6.释放资源
     */
    public void save() {
        Customer c = new Customer();
        c.setName("vini");
        c.setCustLevel("VIP客户");
        c.setCustSource("网络");
        c.setCustIndustry("IT...");
        c.setCustAddress("朝阳公园");
        c.setCustPhone("010-0101011");

        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(c);

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            transaction.commit();
            entityManager.close();
        }
    }

    /**
     * 根据id查询客户
     *  使用find方法查询：
     *      1.查询的对象就是当前客户对象本身
     *      2.在调用find方法的时候，就会发送sql语句查询数据库
     *  立即加载
     */
    public void testFind() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Customer customer = entityManager.find(Customer.class, 4l);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            transaction.commit();
            entityManager.close();
        }
    }

    /**
     * 根据id查询客户
     *      getReference方法
     *          1.获取的对象是一个动态代理对象
     *          2.调用getReference方法不会立即发送sql语句查询数据库
     *              * 当调用查询结果对象的时候，才会发送查询的sql语句：什么时候用，什么时候发送sql语句查询数据库
     *
     * 延迟加载（懒加载）
     *      * 得到的是一个动态代理对象
     *      * 什么时候用，什么使用才会查询
     */
    public void testReference() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Customer customer = entityManager.getReference(Customer.class, 4L);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            transaction.commit();
            entityManager.close();
        }
    }

    /**
     * 需要删除持久态的才可以， 因此先查后删
     */
    public void testRemove() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Customer customer = entityManager.getReference(Customer.class, 4l);
            entityManager.remove(customer);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            transaction.commit();
            entityManager.close();
        }
    }

    /**
     * 更新客户的操作, 也是需要持久态的才可以
     *      merge(Object)
     */
    public void testUpdate() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = JpaUtils.getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            Customer customer = entityManager.getReference(Customer.class, 4l);
            customer.setName("wenbronk");
            entityManager.merge(customer);
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            transaction.commit();
            entityManager.close();
        }
    }

}
