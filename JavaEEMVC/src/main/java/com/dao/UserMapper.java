package com.dao;

import com.fly.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    User getUserById(int id);

    int insertUser(Map map);
    //int insertUser(@Param("nickname") String nickname,@Param("username") String username);
    //int insertUser(User user);
}
