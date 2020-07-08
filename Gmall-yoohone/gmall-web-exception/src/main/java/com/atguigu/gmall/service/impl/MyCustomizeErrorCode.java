package com.atguigu.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.service.CustomizeErrorCode;

@Service
/**
 * @author Jack
 * @date 2019-07-27-18:07
 */
public enum MyCustomizeErrorCode implements CustomizeErrorCode {
    /**
     * 3005:"密码不正确!"
     */
    PASS_NOT_CORRECT(3005, "密码不正确!请重新尝试!"),
    /**
     * 3006:"尚未登录!"
     */
    NOT_LOGIN(3006, "尚未登录!"),
    /**
     * 2005:"没有找到这一条历史信息!有人侵入数据库强制删除了!"
     */
    INTRODUCTION_NOT_FOUND(2005, "没有找到这一条历史信息!有人侵入数据库强制删除了!"),
    /**
     * 404:没有找到对应的请求路径
     */
    PAGE_NOT_FOUND(404, "你要请求的页面好像暂时飘走了...要不试试请求其它页面?"),
    /**
     * 500:服务端异常
     */
    INTERNAL_SERVER_ERROR(500, "服务器冒烟了...要不等它降降温后再来访问?"),
    /**
     * 2001:未知异常
     */
    INTERNAL_SERVER_TO_ERROR(2001, "未知异常,请联系管理员!");

    private String message;
    private Integer code;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    MyCustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    }
