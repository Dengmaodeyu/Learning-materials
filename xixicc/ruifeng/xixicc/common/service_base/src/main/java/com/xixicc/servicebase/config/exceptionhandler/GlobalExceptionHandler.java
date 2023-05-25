package com.xixicc.servicebase.config.exceptionhandler;


import com.xixicc.commonutils.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.security.access.AccessDeniedException;


/**
 * @author pcc
 * @version 1.0
 * @description 全局统一异常处理类
 * @date 2023/3/22 10:31
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error().message("全局异常处理");
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public Result error(AccessDeniedException e){
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.error().message("当前账号无权限访问，请联系管理员授权！");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        e.printStackTrace();
        log.error(e.toString());
        return Result.error().message("执行了特定异常处理");
    }

    @ExceptionHandler(XixiccException.class)
    @ResponseBody
    public Result error(XixiccException e){
        log.error(e.getMessage());
        return Result.error().code(e.getCode()).message(e.getMsg());
    }

}
