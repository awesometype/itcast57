package com.wenbronk.jpa03.dao;

import com.wenbronk.jpa03.domain.Customer;
import com.wenbronk.jpa03.domain.NameOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerPersistence extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    /**
     * jpql 查询
     */
    @Query("from Customer")
    public List<Customer> findAllCustomer();

    @Query("from Customer where name = ?1")
    public Customer findJpql(String custName);

    @Query("from Customer where name = ?2 and custId = ?1")
    public Customer findCustNameAndId(Long id, String custName);

    @Query("from Customer where id = :id and name = :custName")
    public Customer findIdAndCustName(@Param("id") Long id, @Param("custName") String custName);

    @Modifying
    @Query(value = "update Customer set name = ?2 where id = ?1")
    public void updateCustomer(Long custId, String custName);

    /**
     * sql
     */
    @Query(value = "select * from cust_customer where cust_name like :custName", nativeQuery = true)
    public List<Customer> findSql(@Param("custName") String custName);

    /**
     * 方法名称查询
     */
    public Customer findByName(String custName);

    public Customer findByNameAndCustLevel(String custName, String custLevel);

    public List<Customer> findByNameLike(String custName);

    public List<Customer> findByNameLikeAndCustLevel(String custName, String custLevel);

    // distinct
    public List<Customer> findDistinctNameByCustSource(String custSource);

    // ignore case
    public List<Customer> findByCustSourceIgnoreCase(String custSource);

    // ignore case
    public List<Customer> findByCustSourceIgnoreCaseOrderByNameDesc(String custSource);

    // 分割
//    List<Customer> findByCustSource_CustLevel(String custSource, String custLevel);

    // stream
//    Stream<Customer> findByNameStream(String name);

    List<NameOnly> findByNameAndCustSource(String name, String custSource);

}
