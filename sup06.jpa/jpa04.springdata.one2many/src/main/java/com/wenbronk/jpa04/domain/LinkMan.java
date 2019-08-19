package com.wenbronk.jpa04.domain;

import javax.persistence.*;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-05 22:41
 * description:
 */
@Table(name = "link_man")
@Entity
public class LinkMan {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="lkm_id", columnDefinition = "bigint(32) COMMENT '联系人编号(主键)'")
    private Long lkmId;

    @Column(name="lkm_name", columnDefinition = "varchar(16) DEFAULT NULL COMMENT '联系人姓名'")
    private String lkmName;

    @Column(name="lkm_gender", columnDefinition = "char(1) DEFAULT NULL COMMENT '联系人性别'")
    private String lkmGender;

    @Column(name="lkm_phone", columnDefinition = "varchar(16) DEFAULT NULL COMMENT '联系人办公电话'")
    private String lkmPhone;

    @Column(name="lkm_mobile", columnDefinition = "varchar(16) DEFAULT NULL COMMENT '联系人手机'")
    private String lkmMobile;

    @Column(name="lkm_email", columnDefinition = "varchar(64) DEFAULT NULL COMMENT '联系人邮箱'")
    private String lkmEmail;

    @Column(name="lkm_position", columnDefinition = "varchar(16) DEFAULT NULL COMMENT '联系人职位'")
    private String lkmPosition;

    @Column(name="lkm_memo", columnDefinition = "varchar(512) DEFAULT NULL COMMENT '联系人备注'")
    private String lkmMemo;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    private Customer customer;

    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "lkmId=" + lkmId +
                ", lkmName='" + lkmName + '\'' +
                ", lkmGender='" + lkmGender + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' +
                ", lkmMobile='" + lkmMobile + '\'' +
                ", lkmEmail='" + lkmEmail + '\'' +
                ", lkmPosition='" + lkmPosition + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                ", customer=" + customer +
                '}';
    }
}
