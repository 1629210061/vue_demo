package com.hwh.vue_demo.utils;

import com.hwh.vue_demo.entity.ResponseResult;

/**
 * @Description TODO
 * @Author hwh
 * @Date 2020/3/2 14:12
 **/
public class ResultUtils {

    /**
     * 封装返回结果
     */
    public static ResponseResult success(Object object){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(200);
        responseResult.setMsg("成功");
        responseResult.setData(object);
        return responseResult;
    }
    public static ResponseResult success() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(200);
        responseResult.setMsg("成功");
        return responseResult;
    }
    public static ResponseResult fail(Integer code, String msg) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        return responseResult;
    }
}
