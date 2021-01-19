package com.jiang.springboot.controller.redis;


import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiang.springboot.redis.bean.UserEntity;
import com.jiang.springboot.redis.util.RedisUtil;

import lombok.extern.slf4j.Slf4j;


/**
 * @program: springbootdemo
 * @Date: 2019/2/22 15:03
 * @Author: "jiangyunan"
 * @Description:
 */
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {

    private static int ExpireTime = 60; // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("set")
    public boolean redisSet(String key, String value) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setGuid(String.valueOf(1));
        userEntity.setName("zhangsan");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreateTime(new Date());

        // return redisUtil.set(key,userEntity,ExpireTime);

        return redisUtil.set(key, value);
    }

    @RequestMapping("get")
    public Object redisGet(String key) {
        return redisUtil.get(key);
    }

    @RequestMapping("expire")
    public boolean expire(String key) {
        return redisUtil.expire(key, ExpireTime);
    }
}
