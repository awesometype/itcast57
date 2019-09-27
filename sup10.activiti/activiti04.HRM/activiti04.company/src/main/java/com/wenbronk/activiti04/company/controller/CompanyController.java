package com.wenbronk.activiti04.company.controller;

import com.wenbronk.activiti04.common.entity.PageResult;
import com.wenbronk.activiti04.common.entity.Result;
import com.wenbronk.activiti04.common.entity.ResultCode;
import com.wenbronk.activiti04.company.service.CompanyService;
import com.wenbronk.activiti04.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-26 10:34
 * description:
 */
@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable String id){
        Company company =  companyService.findById(id);
        return new Result(ResultCode.SUCCESS,company);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Company company){
        companyService.save(company);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id){
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable("id")String id,@RequestBody Company company){
        companyService.update(id,company);
        return new Result(ResultCode.SUCCESS);
    }

    @RequestMapping(value = "/{page}/{size}",method = RequestMethod.POST)
    public PageResult findByPageList(@PathVariable("page")int page, @PathVariable("size")int size, @RequestBody Company company){
        return companyService.findByPageList(company,(page -1)*size,size);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result findAll() throws Exception {
        List<Company> companyList = companyService.findAll();
        return new Result(ResultCode.SUCCESS, companyList);
    }
}
