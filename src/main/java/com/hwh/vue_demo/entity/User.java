package com.hwh.vue_demo.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String userName;

    private String mobile;

    private Integer type;

    private String email;

    private String createTime;

    private Integer mgState;

    private String roleName;

    private boolean state;

    public boolean getState() {
        return this.state;
    }
}