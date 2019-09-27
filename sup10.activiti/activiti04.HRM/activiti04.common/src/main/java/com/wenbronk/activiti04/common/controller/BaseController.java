package com.wenbronk.activiti04.common.controller;

import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-27 10:04
 * description:
 */
public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Claims claims;
    protected String companyId = "1166177381798133760";
    protected String companyName = "wenbronk";

    @ModelAttribute
    public void setRequsetAndResponse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

        Object user_claims = request.getAttribute("user_claims");
        if (user_claims != null) {
            claims = (Claims) user_claims;
            this.companyId = (String) claims.get("companyId");
            this.companyName = (String) claims.get("companyName");
        }
    }

    //企业id，（暂时使用1,以后会动态获取）
    public String parseCompanyId() {
        return companyId;
    }
    public String parseCompanyName() {
        return companyName;
    }

}
