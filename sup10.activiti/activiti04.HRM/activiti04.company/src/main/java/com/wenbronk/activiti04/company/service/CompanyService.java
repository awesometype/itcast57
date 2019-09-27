package com.wenbronk.activiti04.company.service;

import com.wenbronk.activiti04.common.entity.PageResult;
import com.wenbronk.activiti04.common.utils.IdWorker;
import com.wenbronk.activiti04.company.dao.CompanyRespository;
import com.wenbronk.activiti04.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-26 09:35
 * description:
 */
@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRespository companyDao;

    @Autowired
    private IdWorker idWorker;

    public Company findById(String id) {
        return companyDao.findById(id).get();
    }

    public void save(Company company) {
        company.setId(idWorker.nextId());
        company.setAuditState("0");
        company.setState(0);
        companyDao.save(company);
    }

    public void update(String id, Company company) {
        company.setId(id);
        companyDao.saveAndFlush(company);
    }

    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    public PageResult findByPageList(Company company, int page, int size) {
        PageResult pageResult = new PageResult();
        Page<Company> all = companyDao.findAll(PageRequest.of(page, size));
        pageResult.setTotal(all.getTotalElements());
        pageResult.setRows(all.getContent());
        return pageResult;

    }

    public List<Company> findAll() {
        return companyDao.findAll();
    }

}
