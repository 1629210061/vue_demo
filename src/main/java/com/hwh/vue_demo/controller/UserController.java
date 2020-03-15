package com.hwh.vue_demo.controller;

import com.hwh.vue_demo.entity.PageRequest;
import com.hwh.vue_demo.entity.ResponseResult;
import com.hwh.vue_demo.entity.User;
import com.hwh.vue_demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public ResponseResult findPage(@ModelAttribute PageRequest pageRequest){
        return userService.findPage(pageRequest);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ResponseResult findUserById(Integer id){
        return userService.findUserById(id);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public ResponseResult deleteById(Integer id){
        return userService.deleteById(id);
    }

    /**
     * 更加id更新状态state
     * @param user
     * @return
     */
    @RequestMapping("/updateStateById")
    public ResponseResult updateStateById(@ModelAttribute User user){
        return userService.updateStateById(user);
    }

    /**
     * 跟新用户信息
     * @param user
     * @return
     */
    @RequestMapping("/updateUserById")
    public ResponseResult updateUserById(@RequestBody User user){
        return userService.updateUserById(user);
    }


    /**
     * 添加用户
     */
    @RequestMapping("/insertUser")
    public ResponseResult insertUser(@RequestBody User user){
        return  userService.insertUser(user);
    }
}

