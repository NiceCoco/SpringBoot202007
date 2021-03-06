package com.atguigu.gmall.service;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomizeErrorCode {
    /**
     * 获取错误状态码
     *
     * @return 错误状态码
     */
    Integer getCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMessage();

}

