package com.wenbronk.framework.exception;

import com.wenbronk.framework.model.response.ResultCode;

public class CustomException extends RuntimeException {
    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }
}