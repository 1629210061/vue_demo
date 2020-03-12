package com.hwh.vue_demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwh.vue_demo.entity.PageRequest;
import com.hwh.vue_demo.entity.PageResult;
import com.hwh.vue_demo.entity.ResponseResult;
import com.hwh.vue_demo.entity.User;
import com.hwh.vue_demo.mapper.UserMapper;
import com.hwh.vue_demo.service.UserService;
import com.hwh.vue_demo.utils.PageUtils;
import com.hwh.vue_demo.utils.ResultUtils;
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

    /**
     * 分页查询用户信息
     * @param pageRequest
     * @return
     */
    @Override
    public ResponseResult findPage(PageRequest pageRequest) {
        PageResult pageResult = PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
        ResponseResult success = ResultUtils.success(pageResult);
        return success;
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
        for(User user:users){
            if(user.getMgState()==1){
                user.setState(true);
            }else {
                user.setState(false);
            }
        }
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }
    /**
     * 更新state数据
     * @param user
     * @return
     */
    @Override
    public ResponseResult updateStateById(User user) {
        if(user.getState()){
            user.setMgState(1);
        }else {
            user.setMgState(0);
        }
        int i = userMapper.updateByIdSelective(user);
        return ResultUtils.success(i);
    }


}
