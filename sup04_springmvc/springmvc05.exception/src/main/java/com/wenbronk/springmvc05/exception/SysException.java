package com.wenbronk.springmvc05.exception;

import java.io.Serializable;

/**
 * @Author wenbronk
 * @Date 2019-07-19
 */
public class SysException extends Exception implements Serializable {

    private String message;
    private Integer code;

    public SysException() {
    }

    public SysException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
