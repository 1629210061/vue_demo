package com.hwh.vue_demo.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author hwh
 * @Date 2020/3/1 23:25
 **/
@Data
public class PageResult {

    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 记录总数
     */
    private Integer totalSize;
    /**
     * 页码总数
     */
    private Integer totalPages;
    /**
     * 数据模型
     */
    private List<?> result;
}
