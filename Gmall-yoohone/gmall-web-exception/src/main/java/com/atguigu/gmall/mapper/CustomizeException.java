package com.atguigu.gmall.mapper;

import com.atguigu.gmall.service.CustomizeErrorCode;

/**
 * @author Jack
 * @date 2019-07-27-18:36
 */
public class CustomizeException extends RuntimeException {
 
    private Integer code;
    private String message;
 
    public CustomizeException(CustomizeErrorCode customizeErrorCode) {
 
        this.code = customizeErrorCode.getCode();
        this.message = customizeErrorCode.getMessage();
 
    }
 
    public Integer getCode() {
        return code;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}
