package com.hwh.vue_demo.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author hwh
 * @Date 2020/3/1 23:23
 **/
@Data
public class PageRequest {

    /**
     * 当前页码
     */
    private Integer currentPage;
    /**
     * 每页数量
     */
    private Integer pageSize;
}
