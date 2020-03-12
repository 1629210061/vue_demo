package com.hwh.vue_demo.entity;

import lombok.Data;

/**
 * @Description 请求响应结果
 * @Author hwh
 * @Date 2020/3/2 13:56
 **/
@Data
public class ResponseResult<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;
}
