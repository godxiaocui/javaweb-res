package com.czh.javaweb.mapper;

import com.czh.javaweb.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from javaweb.tb_user where username=#{username} and password =#{password}")
    //@Select("select * from javaweb.tb_user where username=#{username} and password =#{username}")
    User selectUser(@Param("username") String username, @Param("password") String password);
}
