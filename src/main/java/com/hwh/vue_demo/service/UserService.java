package com.hwh.vue_demo.service;

import com.hwh.vue_demo.entity.PageRequest;
import com.hwh.vue_demo.entity.ResponseResult;
import com.hwh.vue_demo.entity.User;

import java.util.List;

/**
 * @Description TODO
 * @Author hwh
 * @Date 2020/3/1 13:54
 **/
public interface UserService {

    /**
     * 获取全部用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 分页查询用户信息
     * @param pageRequest
     * @return
     */
    ResponseResult findPage(PageRequest pageRequest);

    /**
     * 根据id更新state
     */
    ResponseResult updateStateById(User user);

}
