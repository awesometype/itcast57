package com.wenbronk.jpa01.domain;

import javax.persistence.*;

/**
 * wenbronk create at 2019/7/30 09:03
 * describe:
 *  @Entity: 注明是和hibernte有关系的实体类
 *  @Table： 表名
 */
@Entity
@Table(name = "cust_customer")
public class Customer {

    /**
     * @Id： 表明是主键
     * @GeneratedValue： 主键生成策略
     *      AUTO： 自动选择类型
     *      IDENTITY： 自增， 需要数据库支持
     *      SEQUENCE： 序列， 需要数据库支持
     * @Column： 数据库列名
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", columnDefinition = "bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)'")
    private Long custId;

    @Column(name = "cust_name", columnDefinition = "varchar(32) NOT NULL COMMENT '客户名称(公司名称)'")
    private String name;

    @Column(name = "cust_source", columnDefinition = "varchar(32) DEFAULT NULL COMMENT '客户信息来源'")
    private String custSource;

    @Column(name = "cust_industry", columnDefinition = "varchar(32) DEFAULT NULL COMMENT '客户所属行业'")
    private String custIndustry;

    @Column(name = "cust_level", columnDefinition = "varchar(32) DEFAULT NULL COMMENT '客户级别'")
    private String custLevel;

    @Column(name = "cust_address", columnDefinition = "varchar(128) DEFAULT NULL COMMENT '客户联系地址'")
    private String custAddress;

    @Column(name = "cust_phone", columnDefinition = "varchar(64) DEFAULT NULL COMMENT '客户联系电话'")
    private String custPhone;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", name='" + name + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}

