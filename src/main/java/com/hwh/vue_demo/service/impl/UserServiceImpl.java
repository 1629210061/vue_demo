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

import java.util.Date;
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
    public ResponseResult findPage(PageRequest pageRequest) {
        PageResult pageResult = PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
        ResponseResult success = ResultUtils.success(pageResult);
        return success;
    }

    @Override
    public ResponseResult findUserById(Integer id) {
        User user = userMapper.selectById(id);
        return ResultUtils.success(user);
    }

    @Override
    public ResponseResult deleteById(Integer id) {
        int i = userMapper.deleteById(id);
        return ResultUtils.success(i);
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
        String keyWord = pageRequest.getKeyWord();
        if(keyWord!=null&&!"".equals(keyWord)){
            keyWord = "%"+pageRequest.getKeyWord()+"%";
        }
        List<User> users = userMapper.selectPage(keyWord);
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

    @Override
    public ResponseResult updateUserById(User user) {
        int i = userMapper.updateByIdSelective(user);
        return ResultUtils.success(i);
    }


    @Override
    public ResponseResult insertUser(User user) {
        user.setCreateTime(new Date().toString());
        user.setType(1);
        user.setMgState(0);
        user.setRoleName("普通用户");
        User oldUser = userMapper.selectByUsername(user.getUserName());
        if(oldUser!=null){
            return ResultUtils.fail(100,"该用户名已被注册");
        }
        int i = userMapper.insert(user);
        return ResultUtils.success(i);
    }


}
