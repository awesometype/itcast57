package com.wenbronk.framework.model.response;

import lombok.Data;
import lombok.ToString;

/**
 * 统一返回模型
 */
@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {

    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
