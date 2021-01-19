package com.jiang.springboot.login.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.jiang.springboot.login.bean.UserInfo;

@Mapper
@Component
public interface UserMapper {

    @Select("select * from user_info where user_id in (${userIdList})")
    @Results({@Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName")})
    List<UserInfo> batchUserInfo(List<String> userIdList);

    @Select("select * from user_info")
    @Results({@Result(column = "user_id", property = "userId"),
            @Result(column = "user_name", property = "userName")})
    List<UserInfo> batchUserInfoAll();

    @Select("select * from user_info where user_name='${userName}' and password='${password}'")
    @Results({@Result(column = "user_name", property = "userName"),
            @Result(column = "password", property = "password")})
    List<UserInfo> queryUserInfo(@Param("userName") String userName,
                                 @Param("password") String password);
}
