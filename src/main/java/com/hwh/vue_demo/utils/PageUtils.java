package com.hwh.vue_demo.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwh.vue_demo.entity.PageRequest;
import com.hwh.vue_demo.entity.PageResult;
import com.hwh.vue_demo.entity.User;
import com.hwh.vue_demo.mapper.UserMapper;

import java.util.List;

/**
 * @Description TODO
 * @Author hwh
 * @Date 2020/3/1 23:29
 **/
public class PageUtils {


    /**
     * 将分页信息进行封装
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setCurrentPage(pageRequest.getCurrentPage());
        pageResult.setPageSize(pageRequest.getPageSize());
        pageResult.setTotalSize((int) pageInfo.getTotal());
        pageResult.setPageSize(pageInfo.getPages());
        pageResult.setResult(pageInfo.getList());
        return pageResult;
    }



}
