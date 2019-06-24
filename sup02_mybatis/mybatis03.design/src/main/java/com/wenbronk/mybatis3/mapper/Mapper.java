package com.wenbronk.mybatis3.mapper;

/**
 * @Author wenbronk
 * @Date 2019-06-20
 */
public class Mapper {
    /**
     * 执行的sql
     */
    private String queryString;
    /**
     * 执行的类的全限定名
     */
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
