package com.jiang.springboot.mapper;

import com.jiang.springboot.bean.UserInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Mapper
@MapperScan
@Component
public interface UserMapper {

  @Select("select * from user_info where user_id in (${userIdList})")
  @Results({
      @Result(column = "user_id", property = "userId"),
      @Result(column = "user_name", property = "userName")
  })
  List<UserInfo> batchUserInfo(List<String> userIdList);

  @Select("select * from user_info")
  @Results({
      @Result(column = "user_id", property = "userId"),
      @Result(column = "user_name", property = "userName")
  })
  List<UserInfo> batchUserInfoAll();

}
