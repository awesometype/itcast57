package com.wenbronk.activiti04.common.exception;

import com.wenbronk.activiti04.common.entity.ResultCode;
import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class CommonException extends Exception  {

    private ResultCode resultCode;

    private static final long serialVersionUID = 1L;
    public CommonException(){
        this(ResultCode.SERVER_ERROR);
    }
    public CommonException(ResultCode resultCode) {
        super(resultCode.message());
        this.resultCode = resultCode;
    }
}
