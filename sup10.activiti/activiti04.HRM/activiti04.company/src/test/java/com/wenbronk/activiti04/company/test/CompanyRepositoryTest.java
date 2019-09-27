package com.wenbronk.activiti04.company.test;

import com.wenbronk.activiti04.common.utils.IdWorker;
import com.wenbronk.activiti04.company.service.CompanyService;
import com.wenbronk.activiti04.domain.company.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-26 09:42
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private IdWorker idWorker;

    @Test
    public void testAdd() {
        Company company = new Company();
        company.setId(idWorker.nextId());
        company.setName("wenbronk ");
        company.setManagerId("wenbronk");
        company.setVersion("1.0.1");
        company.setRenewalDate(new Date());
        company.setExpirationDate(new Date());
        company.setCompanyArea("china");
        company.setCompanyAddress("bj");
        company.setBusinessLicenseId("uuid02");
        company.setLegalRepresentative("wenbronk");
        company.setCompanyPhone("18333333333");
        company.setMailbox("wenbronk@hotmail.com");
        company.setCompanySize("big");
        company.setIndustry("internet");
        company.setRemarks("hellolololololo");
        company.setAuditState("true");
        company.setState(1);
        company.setBalance(9999999.99);
        company.setCreateTime(new Date());

        companyService.save(company);
    }

}
