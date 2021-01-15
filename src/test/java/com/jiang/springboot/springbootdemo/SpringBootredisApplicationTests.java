package com.jiang.springboot.springbootdemo;

import com.jiang.springboot.redis.bean.User;
import java.util.Objects;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootredisApplicationTests {

  @Autowired
  private RedisOperations redisTemplate;

  @Test
  public void testObj() {
    User user = new User(1, "java的架构师技术栈", "man");
    ValueOperations<String, User> operations = redisTemplate.opsForValue();
    operations.set("fdd2", user);
    boolean exists = redisTemplate.hasKey("fdd2");
    System.out.println("redis是否存在相应的key" + exists);
    User getUser = (User) redisTemplate.opsForValue().get("fdd2");
    System.out
        .println("从redis数据库获取的user:" + Optional.ofNullable(getUser).orElse(new User()).toString());
  }
}
