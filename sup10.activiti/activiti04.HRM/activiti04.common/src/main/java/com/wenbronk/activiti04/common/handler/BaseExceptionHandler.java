package com.wenbronk.activiti04.common.handler;

import com.wenbronk.activiti04.common.entity.Result;
import com.wenbronk.activiti04.common.exception.CommonException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-26 10:31
 * description:
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result error(HttpServletRequest request, HttpServletResponse response,
                        Exception e) throws IOException {
        e.printStackTrace();
        if (e.getClass() == CommonException.class) {
            CommonException ce = (CommonException) e;
            return new Result(ce.getResultCode());
        } else {
            return Result.ERROR();
        }
    }
}
