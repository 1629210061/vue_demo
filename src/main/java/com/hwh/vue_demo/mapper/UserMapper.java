package com.hwh.vue_demo.mapper;

import com.hwh.vue_demo.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    /**
     * 根据id更新数据
     * @param user
     * @return
     */
    int updateByIdSelective(User user);

    int updateByPrimaryKey(User record);

    List<User> selectAll();

    /**
     * 分页查询
     * @return
     */
    List<User> selectPage();
}