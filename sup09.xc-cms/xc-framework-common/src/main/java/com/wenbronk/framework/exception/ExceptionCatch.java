package com.wenbronk.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.wenbronk.framework.model.response.CommonCode;
import com.wenbronk.framework.model.response.ResponseResult;
import com.wenbronk.framework.model.response.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-06 09:11
 * description:
 */
@ControllerAdvice
@Slf4j
public class ExceptionCatch {

    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
//    protected static ImmutableMap.Builder builder =

    public ExceptionCatch() {
        Map<Class<? extends Throwable>,ResultCode> exceptionMap = Maps.newHashMap();
        exceptionMap.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);
        this.build(exceptionMap);
    }

    public void build(Map<Class<? extends Throwable>, ResultCode> exceptionMaps) {
        EXCEPTIONS = ImmutableMap.<Class<? extends Throwable>,ResultCode>builder().putAll(exceptionMaps).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception){
        //记录日志
        log.error("catch exception:{}",exception.getMessage());
        final ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        final ResponseResult responseResult;
        if (resultCode != null) {
            responseResult = new ResponseResult(resultCode);
        } else {
            responseResult = new ResponseResult(CommonCode.SERVER_ERROR);
        }
        return responseResult;
    }

    @ExceptionHandler(value = {CustomException.class})
    @ResponseBody
    public ResponseResult customException(CustomException e) {
        log.error("catch exception {}", e.getMessage());
        return new ResponseResult(e.getResultCode());
    }

}
