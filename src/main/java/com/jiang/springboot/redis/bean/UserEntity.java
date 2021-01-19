package com.jiang.springboot.redis.bean;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
public class UserEntity implements Serializable {

    private Long id;

    private String guid;

    private String name;

    private String age;

    private Date createTime;
}
