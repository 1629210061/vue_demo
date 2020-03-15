package com.hwh.vue_demo.mapper;

import com.hwh.vue_demo.entity.User;

import java.util.List;

public interface UserMapper {

    int deleteById(Integer id);

    int insert(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUserSelective(User user);


    /**
     * 根据id查询
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User selectByUsername(String username);


    /**
     * 查询全部
     * @return
     */
    List<User> selectAll();

    /**
     * 分页查询
     * @return
     */
    List<User> selectPage(String keyWord);


    /**
     * 根据id更新数据
     * @param user
     * @return
     */
    int updateByIdSelective(User user);

    int updateByPrimaryKey(User record);
}