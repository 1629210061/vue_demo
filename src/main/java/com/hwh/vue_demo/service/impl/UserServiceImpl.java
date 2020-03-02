package com.hwh.vue_demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwh.vue_demo.entity.PageRequest;
import com.hwh.vue_demo.entity.PageResult;
import com.hwh.vue_demo.entity.User;
import com.hwh.vue_demo.mapper.UserMapper;
import com.hwh.vue_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author hwh
 * @Date 2020/2/29 21:49
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectAll();
        for(User user:users){
            if(user.getMgState()==1){
                System.out.println(user.getMgState());
                user.setState(true);
            }else {
                user.setState(false);
            }
        }
        return users;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    public PageInfo<User> getPageInfo(PageRequest pageRequest) {
        Integer currentPage = pageRequest.getCurrentPage();
        Integer pageSize = pageRequest.getPageSize();
        PageHelper.startPage(currentPage,pageSize);
        List<User> users = userMapper.selectPage();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

}
