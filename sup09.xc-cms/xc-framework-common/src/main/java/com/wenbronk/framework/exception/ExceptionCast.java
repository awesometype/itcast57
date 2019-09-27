package com.wenbronk.framework.exception;

import com.wenbronk.framework.model.response.ResultCode;


public class ExceptionCast {
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
