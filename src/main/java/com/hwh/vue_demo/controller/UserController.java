package com.hwh.vue_demo.controller;

import com.hwh.vue_demo.entity.PageRequest;
import com.hwh.vue_demo.entity.PageResult;
import com.hwh.vue_demo.entity.User;
import com.hwh.vue_demo.service.UserService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author hwh
 * @Date 2020/3/1 13:56
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询全部用户信息
     * @return
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
    }

    /**
     * 分页查询用户信息
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody PageRequest pageRequest){
        return userService.findPage(pageRequest);
    }
}

