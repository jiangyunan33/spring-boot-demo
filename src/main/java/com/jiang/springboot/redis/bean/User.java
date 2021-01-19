package com.jiang.springboot.redis.bean;


import lombok.Data;


@Data
public class User {

    private Integer id;

    private String userName;

    private String userSex;

    public User() {}

    public User(Integer id, String userName, String userSex) {
        this.id = id;
        this.userName = userName;
        this.userSex = userSex;
    }
}
