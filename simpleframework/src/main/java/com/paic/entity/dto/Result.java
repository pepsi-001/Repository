package com.paic.entity.dto;

public class Result<T> {
    //状态码 200成功
    private int code;
    //请求详情
    private String msg;
    //请求返回结果集
    private T data;
}
