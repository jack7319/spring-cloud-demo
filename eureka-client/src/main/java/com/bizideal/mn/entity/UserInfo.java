package com.bizideal.mn.entity;

import java.io.Serializable;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/12 11:27
 * @version: 1.0
 * @Description:
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 963061236984604666L;

    private String name;
    public int getId() {
        return id;
    }

    private int id;

    public UserInfo setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserInfo setName(String name) {
        this.name = name;
        return this;
    }
}
