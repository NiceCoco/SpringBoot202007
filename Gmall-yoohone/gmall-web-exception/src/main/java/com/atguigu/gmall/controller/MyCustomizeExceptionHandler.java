package com.atguigu.gmall.controller;

import com.atguigu.gmall.mapper.CustomizeException;
import com.atguigu.gmall.service.impl.MyCustomizeErrorCode;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.ognl.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jack
 * @date 2019-07-27-18:34
 */
@ControllerAdvice
public class MyCustomizeExceptionHandler {
 
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @Override
    public ResultDTO handleCustomizeException(HttpServletRequest request, Throwable ex) {
 
        //获取错误状态码
        HttpStatus status = getStatus(request);
        //判断是否匹配自定义异常
        if (ex instanceof CustomizeException) {
            CustomizeException customizeException = (CustomizeException) ex;
            ResultDTO resultDTO = ResultDTO.errorOf(customizeException.getCode(), customizeException.getMessage());
            System.out.println(resultDTO.toString());
            return resultDTO;
        }
        //判断是否5xx类型异常
        if (status.is5xxServerError() || ex instanceof ParseException) {
            ResultDTO resultDTO = ResultDTO.errorOf(MyCustomizeErrorCode.INTERNAL_SERVER_ERROR);
            return resultDTO;
        }
 
        return ResultDTO.errorOf(MyCustomizeErrorCode.UNKNOWN_ERROR);
 
    }
}
